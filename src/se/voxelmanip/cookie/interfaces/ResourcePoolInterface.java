package se.voxelmanip.cookie.interfaces;

/**
 * Interface for a resource pool
 * @author ROllerozxa
 */
public interface ResourcePoolInterface {
    /**
     * Get current amount
     * @return Current amount
     */
    long get();

    /**
     * Get (accumulated) all time amount
     * @return All time amount
     */
    long getAllTime();

    /**
     * Increment amount by one
     */
    void increment();

    /**
     * Decrement amount by one
     */
    void decrement();

    /**
     * Add an arbitrary amount
     * @param value Amount
     */
    void add(long value);

    /**
     * Remove an arbitrary amount
     * @param value Amount
     */
    void remove(long value);
}
