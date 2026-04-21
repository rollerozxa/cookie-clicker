package se.voxelmanip.cookie.interfaces;

/**
 * Interface for getting information from a loaded save game.
 * @author ROllerozxa
 */
public interface SaveGameInfoInterface {

    /**
     * Get timestamp of savegame
     * @return Timestamp
     */
    long getSaveTime();

    /**
     * Get stored amount of cookies
     * @return Amount of cookies
     */
    long getCookies();

    /**
     * Get stored amount of cookies for all time (accumulated total)
     * @return Amount of cookies for all time
     */
    long getCookiesAllTime();

    /**
     * Get stored amount of autoclickers
     * @return Amount of autoclickers
     */
    long getAutoclickers();

    /**
     * Get stored amount of click upgrades
     * @return Amount of click upgrades
     */
    long getClickUpgrades();
}
