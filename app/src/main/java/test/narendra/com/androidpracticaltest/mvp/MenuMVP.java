package test.narendra.com.androidpracticaltest.mvp;

import test.narendra.com.androidpracticaltest.modal.MenuItemsModel;

/**
 * <h1>MenuMVP, provides contract for MVP implementaion</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class MenuMVP {

    /**
     * View operations P->V
     */
    public interface RequiredViewOps {
        void showMenuItems(MenuItemsModel menuItems);

        void showMessage(String message);
    }

    /**
     * Presentor operations V->P
     */
    public interface PresentorOps {
        void getMenuItems();
    }

    /**
     * Presentor operations P->P
     */
    public interface PresentorRequiredOps {
        void menuItemsSuccess(MenuItemsModel menuItems);

        void menuItemsFailure(String message);
    }

}
