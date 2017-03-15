package test.narendra.com.androidpracticaltest.modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * <h1>MenuItemsModel, contains listing for different type of menus used in the app.</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class MenuItemsModel {

    private List<TopMenuBean> topmenu;
    private List<SubMenuBean> submenu;

    public List<TopMenuBean> getTopmenu() {
        return topmenu;
    }

    public void setTopmenu(List<TopMenuBean> topmenu) {
        this.topmenu = topmenu;
    }

    public List<SubMenuBean> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<SubMenuBean> submenu) {
        this.submenu = submenu;
    }

    public static class TopMenuBean {
        private int id;
        private String name;
        private int issubmenu;
        private boolean isSelected;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIssubmenu() {
            return issubmenu;
        }

        public void setIssubmenu(int issubmenu) {
            this.issubmenu = issubmenu;
        }
    }

    public static class SubMenuBean {
        private String name;

        @SerializedName("issubmenu")
        private int isSubMenu;

        @SerializedName("mainmenuId")
        private int mainmenuId;

        @SerializedName("mainMenuId")
        private int mainMenuId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIsSubMenu() {
            return isSubMenu;
        }

        public void setIsSubMenu(int isSubMenu) {
            this.isSubMenu = isSubMenu;
        }

        public int getMainmenuId() {
            return mainmenuId;
        }

        public void setMainmenuId(int mainmenuId) {
            this.mainmenuId = mainmenuId;
        }

        public int getMainMenuId() {
            return mainMenuId;
        }

        public void setMainMenuId(int mainMenuId) {
            this.mainMenuId = mainMenuId;
        }
    }
}
