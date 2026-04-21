package se.voxelmanip.cookie.controllers;

import se.voxelmanip.cookie.models.ClickerModel;
import se.voxelmanip.cookie.models.CookiePoolModel;
import se.voxelmanip.cookie.models.TimeTravelModel;
import se.voxelmanip.cookie.models.UnixTimeModel;

/**
 * Controller for the game's "Time travel" functionality, retroactively adding cookies that would
 * have been generated while the game has been closed.
 * @author ROllerozxa
 */
public class TimeTravelController {
    private final long lastSaveTime;
    private final CookiePoolModel cookiePoolModel;
    private final ClickerModel clickerModel;
    private final TimeTravelModel timeTravelModel;
    private final UnixTimeModel unixTimeModel;
    private long accumulatedCookies;

    /**
     * Constructor method
     * @param lastSaveTime Last save time as unix timestamp
     * @param cookiePoolModel Cookie pool model
     * @param clickerModel Clicker model
     */
    public TimeTravelController(long lastSaveTime, CookiePoolModel cookiePoolModel, ClickerModel clickerModel) {
        this.lastSaveTime = lastSaveTime;
        this.cookiePoolModel = cookiePoolModel;
        this.clickerModel = clickerModel;
        this.timeTravelModel = new TimeTravelModel();
        this.unixTimeModel = new UnixTimeModel();
    }

    /**
     * Initiate time travel, the accumulated cookies will be added to the cookie pool
     */
    public void timeTravel() {
        accumulatedCookies = timeTravelModel.calculateRetroactiveCookies(
                lastSaveTime, unixTimeModel.getCurrentUnixTime(), clickerModel.get());
        cookiePoolModel.add(accumulatedCookies);
    }

    /**
     * Get the amount of cookies that had accumulated since last time
     * @return Accumulated cookies
     */
    public long getAccumulatedCookies() {
        return this.accumulatedCookies;
    }
}
