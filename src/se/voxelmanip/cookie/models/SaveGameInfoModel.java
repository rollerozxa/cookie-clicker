package se.voxelmanip.cookie.models;

import se.voxelmanip.cookie.interfaces.SaveGameInfoInterface;

/**
 * Class used to store the state of the game when interfacing with the SaveGameModel.
 * @author ROllerozxa
 */
public class SaveGameInfoModel implements SaveGameInfoInterface {
    private final long cookies;
    private final long cookiesAllTime;
    private final long autoclickers;
    private final long clickUpgrades;
    private final long saveTime;

    /**
     * Constructor method
     * @param saveTime Timestamp of save
     * @param cookies Amount of cookies
     * @param cookiesAllTime Amount of cookies all time (accumulated total)
     * @param autoclickers Amount of autoclickers
     * @param clickUpgrades Amount of click upgrades
     */
    public SaveGameInfoModel(long saveTime, long cookies, long cookiesAllTime, long autoclickers, long clickUpgrades) {
        this.saveTime = saveTime;
        this.cookies = cookies;
        this.cookiesAllTime = cookiesAllTime;
        this.autoclickers = autoclickers;
        this.clickUpgrades = clickUpgrades;
    }

    /**
     * Get timestamp of savegame
     * @return Timestamp
     */
    public long getSaveTime() {
        return saveTime;
    }

    /**
     * Get stored amount of cookies
     * @return Amount of cookies
     */
    public long getCookies() {
        return cookies;
    }

    /**
     * Get stored amount of cookies for all time (accumulated total)
     * @return Amount of cookies for all time
     */
    public long getCookiesAllTime() {
        return cookiesAllTime;
    }

    /**
     * Get stored amount of autoclickers
     * @return Amount of autoclickers
     */
    public long getAutoclickers() {
        return autoclickers;
    }

    /**
     * Get stored amount of click upgrades
     * @return Amount of click upgrades
     */
    public long getClickUpgrades() {
        return clickUpgrades;
    }
}
