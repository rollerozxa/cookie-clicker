package se.voxelmanip.cookie.models;

import se.voxelmanip.cookie.interfaces.StoreInterface;
import se.voxelmanip.cookie.util.AppConfig;

/**
 * Model class which stores the information for a buy clicker entry in the store.
 * @author ROllerozxa
 */
public class BuyClickUpgradeModel implements StoreInterface {
    private final long amount;
    private final long cost;

    /**
     * Constructor method
     * @param amount Amount of click upgrades
     */
    public BuyClickUpgradeModel(long amount) {
        this.amount = amount;
        this.cost = amount * AppConfig.clickUpgradeCost;
    }

    /**
     * Get amount of click upgrades the button will purchase
     * @return Amount of click upgrades to be purchased
     */
    public long getAmount() {
        return this.amount;
    }

    /**
     * Get how many cookies the amount of click upgrades will cost
     * @return Total cost in cookies
     */
    public long getTotalCost() {
        return this.cost;
    }
}
