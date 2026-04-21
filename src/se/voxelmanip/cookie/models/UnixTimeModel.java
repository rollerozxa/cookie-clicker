package se.voxelmanip.cookie.models;

/**
 * Model that provides methods to retrieve unix timestamps
 * @author ROllerozxa
 */
public class UnixTimeModel {

    /**
     * Get the current unix time with millisecond accuracy
     * @return Unix time in milliseconds
     */
    public long getCurrentUnixTimeMilli() {
        return System.currentTimeMillis();
    }

    /**
     * Get the current unix time with second accuracy
     * @return Unix time in seconds
     */
    public long getCurrentUnixTime() {
         return getCurrentUnixTimeMilli() / 1000L;
    }
}
