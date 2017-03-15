package test.narendra.com.androidpracticaltest.modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * <h1>MenuContentsModel, contains data about different menus in {@link MenuItemsModel}</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @see MenuItemsModel
 * @since 05-03-2017
 */

public class MenuContentsModel {
    @SerializedName("menuitem")
    private List<MenuItemBean> menuItems;

    public List<MenuItemBean> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemBean> menuItems) {
        this.menuItems = menuItems;
    }

    public static class MenuItemBean {
        private int id;

        @SerializedName("item_name")
        private String itemName;

        @SerializedName("submenu_id")
        private int subMenuId;

        @SerializedName("mainmenu_id")
        private int mainMenuId;

        @SerializedName("description")
        private String description;

        @SerializedName("image_path")
        private String imagePath;

        @SerializedName("item_price")
        private String itemPrice;

        @SerializedName("item_count")
        private int itemCount;

        @SerializedName("cart_item")
        private int cartItem;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public int getSubMenuId() {
            return subMenuId;
        }

        public void setSubMenuId(int subMenuId) {
            this.subMenuId = subMenuId;
        }

        public int getMainMenuId() {
            return mainMenuId;
        }

        public void setMainMenuId(int mainMenuId) {
            this.mainMenuId = mainMenuId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(String itemPrice) {
            this.itemPrice = itemPrice;
        }

        public int getItemCount() {
            return itemCount;
        }

        public void setItemCount(int itemCount) {
            this.itemCount = itemCount;
        }

        public int getCartItem() {
            return cartItem;
        }

        public void setCartItem(int cartItem) {
            this.cartItem = cartItem;
        }
    }
}
