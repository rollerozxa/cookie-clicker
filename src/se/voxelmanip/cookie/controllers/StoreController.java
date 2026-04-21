package se.voxelmanip.cookie.controllers;

import se.voxelmanip.cookie.models.BuyClickUpgradeModel;
import se.voxelmanip.cookie.models.BuyClickerModel;
import se.voxelmanip.cookie.models.ClickUpgradeModel;
import se.voxelmanip.cookie.models.ClickerModel;
import se.voxelmanip.cookie.models.CookiePoolModel;
import se.voxelmanip.cookie.models.FormatterModel;
import se.voxelmanip.cookie.models.FormatterSymbolModel;
import se.voxelmanip.cookie.views.BuyButtonView;

import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class used for the management of the in-game store
 * @author ROllerozxa
 */
public class StoreController {
    private final FormatterModel formatterModel;
    private final CookiePoolModel cookiePoolModel;
    private final ClickerModel clickerModel;
    private final ClickUpgradeModel clickUpgradeModel;

    /**
     * Constructor method
     * @param cookiePoolModel Cookie pool model
     * @param clickerModel Clicker model
     * @param clickUpgradeModel Click upgrade model
     */
    public StoreController(CookiePoolModel cookiePoolModel, ClickerModel clickerModel, ClickUpgradeModel clickUpgradeModel) {
        this.formatterModel = new FormatterModel(new FormatterSymbolModel().getSymbols());
        this.cookiePoolModel = cookiePoolModel;
        this.clickerModel = clickerModel;
        this.clickUpgradeModel = clickUpgradeModel;
    }

    /**
     * Create store buttons for buying autoclickers
     * @param updateView Callback for updating a view
     * @return List of purchase buttons
     */
    public List<JButton> createAutoclickerButtons(Runnable updateView) {
        List<JButton> buttonList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // Step the quantity in logarithmic order (1, 10, 100, 1000, etc.)

            BuyClickerModel buyClickerModel = new BuyClickerModel((long)Math.pow(10, i));
            BuyButtonView buyClickerView = new BuyButtonView(buyClickerModel, formatterModel.getFormatter());

            buyClickerView.addActionListener(e -> {
                // Check if the player can afford the purchase
                if (cookiePoolModel.get() < buyClickerModel.getTotalCost()) return;

                // Consume cookies and add the amount of purchased clickers
                cookiePoolModel.remove(buyClickerModel.getTotalCost());
                clickerModel.add(buyClickerModel.getAmount());
                updateView.run();
            });
            buttonList.add(buyClickerView);
        }

        return buttonList;
    }

    /**
     * Create store buttons for buying click upgrades
     * @param updateView Callback for updating a view
     * @return List of purchase buttons
     */
    public List<JButton> createClickUpgradeButtons(Runnable updateView) {
        List<JButton> buttonList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // Step the quantity in logarithmic order (1, 10, 100, 1000, etc.)

            BuyClickUpgradeModel buyClickUpgradeModel = new BuyClickUpgradeModel((long) Math.pow(10, i));
            BuyButtonView buyButtonView = new BuyButtonView(buyClickUpgradeModel, formatterModel.getFormatter());

            buyButtonView.addActionListener(e -> {
                // Check if the player can afford the purchase
                if (cookiePoolModel.get() < buyClickUpgradeModel.getTotalCost()) return;

                // Consume cookies and add the amount of purchased clickers
                cookiePoolModel.remove(buyClickUpgradeModel.getTotalCost());
                clickUpgradeModel.add(buyClickUpgradeModel.getAmount());
                updateView.run();
            });
            buttonList.add(buyButtonView);
        }

        return buttonList;
    }
}
