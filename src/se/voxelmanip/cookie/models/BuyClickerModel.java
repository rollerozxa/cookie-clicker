package se.voxelmanip.cookie.models;

import se.voxelmanip.cookie.interfaces.StoreInterface;
import se.voxelmanip.cookie.util.AppConfig;

/**
 * Model class which stores the information for a buy clicker entry in the store.
 * @author ROllerozxa
 */
public class BuyClickerModel implements StoreInterface {
    private final long amount;
    private final long cost;

    /**
     * Constructor method
     * @param amount Amount of autoclickers
     */
    public BuyClickerModel(long amount) {
        this.amount = amount;
        this.cost = amount * AppConfig.autoClickerCost;
    }

    /**
     * Get amount of autoclickers the button will purchase
     * @return Amount of autoclickers to be purchased
     */
    public long getAmount() {
        return this.amount;
    }

    /**
     * Get how many cookies the amount of autoclickers will cost
     * @return Total cost in cookies
     */
    public long getTotalCost() {
        return this.cost;
    }
}
