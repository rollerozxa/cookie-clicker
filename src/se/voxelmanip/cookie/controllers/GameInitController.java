package se.voxelmanip.cookie.controllers;

import se.voxelmanip.cookie.exceptions.UnitialisedException;
import se.voxelmanip.cookie.interfaces.SaveGameInfoInterface;
import se.voxelmanip.cookie.models.ClickUpgradeModel;
import se.voxelmanip.cookie.models.ClickerModel;
import se.voxelmanip.cookie.models.CookiePoolModel;

/**
 * Controller class used for initialisation of game entities depending on if a savegame exists or not
 * @author ROllerozxa
 */
public class GameInitController {
    private final SaveGameController saveGameController;
    private ClickerModel clickerModel;
    private CookiePoolModel cookiePoolModel;
    private boolean initialised;
    private boolean loadingExistingSave;
    private ClickUpgradeModel clickUpgradeModel;
    private TimeTravelController timeTravelController;

    /**
     * Constructor method
     * @param saveGameController A save game controller entity for reading a saved game
     */
    public GameInitController(SaveGameController saveGameController) {
        this.saveGameController = saveGameController;
    }

    /**
     * Initialise game entities that can then be retrieved with respective methods
     */
    public void initialise() {
        CookiePoolModel tempCookie = null;
        ClickerModel tempClicker = null;
        ClickUpgradeModel tempClickUpgrade = null;
        this.loadingExistingSave = false;
        if (saveGameController.hasSavedGame()) {
            try {
                SaveGameInfoInterface info = saveGameController.loadState();

                // Instantiate CookiePool and Clicker with overload that accepts an initial state
                tempCookie = new CookiePoolModel(info.getCookies(), info.getCookiesAllTime());
                tempClicker = new ClickerModel(tempCookie, info.getAutoclickers());
                tempClickUpgrade = new ClickUpgradeModel(info.getClickUpgrades());

                this.loadingExistingSave = true;
                System.out.println("Loaded from savegame data");

                this.timeTravelController = new TimeTravelController(info.getSaveTime(), tempCookie, tempClicker);
                this.timeTravelController.timeTravel();

            } catch (Exception e) {
                System.out.println("Error occurred while trying to load savegame: " + e.getMessage());
            }
        }

        // Either there is no existing save, or it is corrupted.
        if (!this.loadingExistingSave) {
            tempCookie = new CookiePoolModel();
            tempClicker = new ClickerModel(tempCookie);
            tempClickUpgrade = new ClickUpgradeModel();
        }

        this.cookiePoolModel = tempCookie;
        this.clickerModel = tempClicker;
        this.clickUpgradeModel = tempClickUpgrade;
        this.initialised = true;
    }

    /**
     * Check if class has been initialised
     */
    private void checkInitialised() {
        if (!this.initialised) {
            throw new UnitialisedException("Controller has not been initialised");
        }
    }

    /**
     * Get cookie pool model. Class needs to be initialised first!
     * @return Cookie pool model
     */
    public CookiePoolModel getCookiePoolModel() {
        checkInitialised();

        return this.cookiePoolModel;
    }

    /**
     * Get autoclicker model. Class needs to be initialised first!
     * @return Clicker model
     */
    public ClickerModel getClickerModel() {
        checkInitialised();

        return this.clickerModel;
    }

    /**
     * Get click upgrade model. Class needs to be initialised first!
     * @return Click upgrade model
     */
    public ClickUpgradeModel getClickUpgradeModel() {
        checkInitialised();

        return this.clickUpgradeModel;
    }

    /**
     * Get accumulated cookies from time travel controller
     * @return Accumulated cookies
     */
    public long getAccumulatedCookies() {
        checkInitialised();

        return this.timeTravelController.getAccumulatedCookies();
    }

    /**
     * Whether an existing save has been loaded or if we're starting the game from scratch
     * @return true/false
     */
    public boolean loadedExistingSave() {
        checkInitialised();

        return loadingExistingSave;
    }
}
