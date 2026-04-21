package se.voxelmanip.cookie.models;

import se.voxelmanip.cookie.util.AppConfig;

/**
 * Model for calculating the amount of accumulated cookies that have occurred since the game
 * was last opened.
 * @author ROllerozxa
 */
public class TimeTravelModel {
    /**
     * Retroactively calculate how many cookies would have been generated while the program was closed
     * @param lastSaveTime Last save time as unix timestamp
     * @param currentTime Current time as unix timestamp
     * @param autoclickers Amount of autoclickers
     * @return Resulting amount of generated cookies
     */
    public long calculateRetroactiveCookies(long lastSaveTime, long currentTime, long autoclickers) {
        long seconds = (currentTime - lastSaveTime);

        long cookies = seconds * autoclickers;

        return Math.min(cookies, AppConfig.timeTravelCookieCap);
    }
}
