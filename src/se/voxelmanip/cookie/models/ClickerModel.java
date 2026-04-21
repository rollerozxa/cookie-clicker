package se.voxelmanip.cookie.models;

import se.voxelmanip.cookie.interfaces.ResourcePoolInterface;
import se.voxelmanip.cookie.util.AppConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Model for managing autoclickers and running their "clicks" in a separate thread
 * @author ROllerozxa
 */
public class ClickerModel {
    private final ExecutorService autoClickerPool = Executors.newCachedThreadPool();
    private ResourcePoolInterface cookiePool;

    private long numAutoClickers;

    /**
     * Constructor for the clicker model with initial amount of autoclickers defined
     * @param cookiePool A resource pool object to collect cookies into
     * @param autoClickers Initial amount of autoclickers
     */
    public ClickerModel(ResourcePoolInterface cookiePool, long autoClickers) {
        this.cookiePool = cookiePool;
        this.numAutoClickers = autoClickers;

        // Launch separate autoclicker thread that will be running continuously throughout the lifespan of the game session.
        autoClickerPool.execute(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(AppConfig.autoclickerFreq);
                    cookiePool.add(numAutoClickers * AppConfig.autoClickerGen);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    /**
     * Constructor for the clicker model
     * @param cookiePool A resource pool object to collect cookies into
     */
    public ClickerModel(ResourcePoolInterface cookiePool) {
        this(cookiePool, 0);
    }

    /**
     * Add an autoclicker
     */
    public void add() {
        numAutoClickers++;
    }

    /**
     * Add an amount of autoclickers
     * @param amount Amount
     */
    public void add(long amount) {
        numAutoClickers += amount;
    }

    /**
     * Remove an autoclicker
     */
    public void remove() {
        numAutoClickers--;
    }

    /**
     * Remove an amount of autoclickers
     * @param amount Amount
     */
    public void remove(long amount) {
        numAutoClickers -= amount;
    }

    /**
     * Get the amount of autoclickers current purchased
     * @return Amount of autoclickers
     */
    public long get() {
        return numAutoClickers;
    }
}
