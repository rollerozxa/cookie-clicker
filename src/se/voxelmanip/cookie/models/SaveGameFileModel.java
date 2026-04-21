package se.voxelmanip.cookie.models;

import se.voxelmanip.cookie.util.AppConfig;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Model class which determines the path of the save file and provides utilities to determine if the save file exists.
 * @author ROllerozxa
 */
public class SaveGameFileModel {
    private final String saveFilePath;

    /**
     * Constructor method
     */
    public SaveGameFileModel() {
        String jarLocation;
        try {
            jarLocation = new File(SaveGameFileModel.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI())
                    .getParent();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        this.saveFilePath = new File(jarLocation, AppConfig.saveFile).toString();
    }

    /**
     * Get path of save file as a string
     * @return Save file path string
     */
    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    /**
     * Whether a saved game exists
     * @return boolean
     */
    public boolean getSaveFileExists() {
        File saveFile = new File(saveFilePath);
        return saveFile.exists();
    }
}
