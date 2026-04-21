package se.voxelmanip.cookie.controllers;

import se.voxelmanip.cookie.interfaces.SaveGameInfoInterface;
import se.voxelmanip.cookie.models.SaveGameInfoModel;
import se.voxelmanip.cookie.models.SaveGameFileModel;
import se.voxelmanip.cookie.util.AppConfig;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Timer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.function.Supplier;

/**
 * Controller class for managing saving and loading the game state in a persistent manner to file.
 * @author ROllerozxa
 */
public class SaveGameController {
    private final SaveGameFileModel saveGameFileModel;

    /**
     * Constructor method
     */
    public SaveGameController() {
        this.saveGameFileModel = new SaveGameFileModel();
    }

    /**
     * Whether a saved game exists
     * @return boolean
     */
    public boolean hasSavedGame() {
        return this.saveGameFileModel.getSaveFileExists();
    }

    /**
     * Save the game now.
     * @param info Savegame state info object
     * @throws IOException If something goes wrong while writing the file
     */
    public void saveState(SaveGameInfoInterface info) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(saveGameFileModel.getSaveFilePath()))) {
            out.write(AppConfig.saveHeader.getBytes()); // Magic header
            out.writeLong(info.getSaveTime());
            out.writeLong(info.getCookies());
            out.writeLong(info.getCookiesAllTime());
            out.writeLong(info.getAutoclickers());
            out.writeLong(info.getClickUpgrades());
            out.flush();
        }

        System.out.println("Game state saved");
    }

    /**
     * Load the game now. Check if a saved game exists with hasSavedGame() before!
     * @return Savegame state info object
     * @throws IOException If something goes wrong while reading the file
     */
    public SaveGameInfoInterface loadState() throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream(saveGameFileModel.getSaveFilePath()))) {
            in.skipBytes(4); // Magic header
            long saveTime = in.readLong();
            long cookies = in.readLong();
            long cookiesAllTime = in.readLong();
            long autoclickers = in.readLong();
            long clickUpgrades = in.readLong();

            return new SaveGameInfoModel(saveTime, cookies, cookiesAllTime, autoclickers, clickUpgrades);
        }
    }

    /**
     * Save the game
     * @param callback Callback with data about the game state that should be saved into file
     */
    private void saveGame(Supplier<SaveGameInfoInterface> callback) {
        try {
            SaveGameInfoInterface info = callback.get();
            saveState(info);
        } catch (IOException ex) {
            System.out.println("Error occurred while trying to save savegame: " + ex.toString());
        }
    }

    /**
     * Start the save timer, saving the game's state at regular intervals
     * @param windowView Window object for overriding its close behaviour
     * @param callback Callback with data about the game state that should be saved into file
     */
    public void startSaveTimer(JFrame windowView, Supplier<SaveGameInfoInterface> callback) {
        Timer timer = new Timer(AppConfig.autosaveFreq, e -> saveGame(callback));
        timer.start();

        windowView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveGame(callback);

                // This may not be very elegant, but it is what Swing generally does with the typical
                // `JFrame.EXIT_ON_CLOSE` behaviour anyway, killing any child threads in the process.
                System.exit(0);
            }
        });
    }
}
