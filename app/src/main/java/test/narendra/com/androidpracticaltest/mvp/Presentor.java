package test.narendra.com.androidpracticaltest.mvp;

import test.narendra.com.androidpracticaltest.modal.MenuItemsModel;
import test.narendra.com.androidpracticaltest.utils.AssetsReader;

/**
 * <h1>Presentor, Presentor for {@link MenuMVP}</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @see MenuMVP
 * @since 05-03-2017
 */

public class Presentor implements MenuMVP.PresentorOps, MenuMVP.PresentorRequiredOps {
    private MenuMVP.RequiredViewOps mViewOps;

    public Presentor(MenuMVP.RequiredViewOps requiredViewOps) {
        this.mViewOps = requiredViewOps;
    }

    @Override
    public void getMenuItems() {
        MenuItemsModel menuItemsModel = AssetsReader.getInstance().getMenuItems();
        if (menuItemsModel != null) {
            menuItemsSuccess(menuItemsModel);
        } else {
            menuItemsFailure("Error while retrieving menu items");
        }
    }

    @Override
    public void menuItemsSuccess(MenuItemsModel menuItems) {
        mViewOps.showMenuItems(menuItems);
    }

    @Override
    public void menuItemsFailure(String message) {
        mViewOps.showMessage(message);
    }
}
