package se.voxelmanip.cookie.controllers;

import se.voxelmanip.cookie.models.ClickUpgradeModel;
import se.voxelmanip.cookie.models.ClickerModel;
import se.voxelmanip.cookie.models.CookiePoolModel;
import se.voxelmanip.cookie.models.FormatterModel;
import se.voxelmanip.cookie.models.FormatterSymbolModel;
import se.voxelmanip.cookie.models.SaveGameInfoModel;
import se.voxelmanip.cookie.models.UnixTimeModel;
import se.voxelmanip.cookie.views.GameView;

import javax.swing.JButton;
import javax.swing.Timer;
import java.util.List;

/**
 * Main controller class, run from the main entrypoint and tying the models and views together
 * @author ROllerozxa
 */
public class GameController {
    private final CookiePoolModel cookiePoolModel;
    private final ClickerModel clickerModel;
    private final GameView gameView;
    private final ClickUpgradeModel clickUpgradeModel;

    /**
     * Game controller constructor method
     */
    public GameController() {
        SaveGameController saveGameController = new SaveGameController();

        GameInitController gameInitController = new GameInitController(saveGameController);
        gameInitController.initialise();
        this.cookiePoolModel = gameInitController.getCookiePoolModel();
        this.clickerModel = gameInitController.getClickerModel();
        this.clickUpgradeModel = gameInitController.getClickUpgradeModel();

        this.gameView = new GameView(new FormatterModel(new FormatterSymbolModel().getSymbols()).getFormatter());

        WindowController windowController = new WindowController();

        CookieController cookieController = new CookieController(cookiePoolModel, clickUpgradeModel, this::updateView);

        StoreController storeController = new StoreController(cookiePoolModel, clickerModel, clickUpgradeModel);

        List<JButton> autoclickerList = storeController.createAutoclickerButtons(this::updateView);
        List<JButton> clickUpgradeList = storeController.createClickUpgradeButtons(this::updateView);

        gameView.constructLayout(windowController.getView(), cookieController.getCookieView(), autoclickerList, clickUpgradeList);

        startUpdateTimer();
        UnixTimeModel unixTimeModel = new UnixTimeModel();
        saveGameController.startSaveTimer(windowController.getView(), () -> new SaveGameInfoModel(
                unixTimeModel.getCurrentUnixTime(),
                cookiePoolModel.get(),
                cookiePoolModel.getAllTime(),
                clickerModel.get(),
                clickUpgradeModel.get()));

        windowController.showStartupMessage(!gameInitController.loadedExistingSave(), gameInitController.getAccumulatedCookies());
    }

    /**
     * Start the update timer, updating relevant things at a 150ms interval
     */
    private void startUpdateTimer() {
        Timer timer = new Timer(150, e -> updateView());
        timer.start();

        // Update view immediately first time
        updateView();
    }

    /**
     * Update view information from model data
     */
    private void updateView() {
        gameView.setGameStatus(cookiePoolModel.get(), cookiePoolModel.getAllTime(), clickerModel.get(), clickUpgradeModel.get());
    }
}
