package se.voxelmanip.cookie.models;

/**
 * Model for managing click upgrades
 * @author ROllerozxa
 */
public class ClickUpgradeModel {
    private long numClickUpgrades;

    /**
     * Constructor for the click upgrade model with initial amount of click upgrades defined
     * @param clickUpgrades Initial amount of click upgrades
     */
    public ClickUpgradeModel(long clickUpgrades) {
        this.numClickUpgrades = clickUpgrades;
    }

    /**
     * Constructor for the click upgrade model
     */
    public ClickUpgradeModel() {
        this(0);
    }

    /**
     * Add a click upgrade
     */
    public void add() {
        numClickUpgrades++;
    }

    /**
     * Add an amount of click upgrades
     * @param amount Amount
     */
    public void add(long amount) {
        numClickUpgrades += amount;
    }

    /**
     * Remove a click upgrade
     */
    public void remove() {
        numClickUpgrades--;
    }

    /**
     * Remove an amount of click upgrades
     * @param amount Amount
     */
    public void remove(long amount) {
        numClickUpgrades -= amount;
    }

    /**
     * Get the amount of click upgrades current purchased
     * @return Amount of click upgrades
     */
    public long get() {
        return numClickUpgrades;
    }
}
