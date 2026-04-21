package se.voxelmanip.cookie.interfaces;

/**
 * Interface for a type of item that gets sold in the store
 * @author ROllerozxa
 */
public interface StoreInterface {
    /**
     * Get amount of items the button will purchase
     * @return Amount of items to be purchased
     */
    long getAmount();

    /**
     * Get how many cookies the amount of an item will cost
     * @return Total cost in cookies
     */
    long getTotalCost();
}
