package test.narendra.com.androidpracticaltest.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import test.narendra.com.androidpracticaltest.modal.MenuItemsModel;
import test.narendra.com.androidpracticaltest.ui.fragments.MenuListFragment;

/**
 * <h1>SubMenuTabsAdapter</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class SubMenuTabsAdapter extends FragmentPagerAdapter {
    String mSubMenuArray[];
    List<MenuItemsModel.SubMenuBean> mlisSubmenuBeen;

    public SubMenuTabsAdapter(FragmentManager fm, List<MenuItemsModel.SubMenuBean> mlisSubmenuBeen) {
        super(fm);
        this.mlisSubmenuBeen = mlisSubmenuBeen;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return MenuListFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        if (mlisSubmenuBeen != null) {
            return mlisSubmenuBeen.size();
        }
        return 0;

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mlisSubmenuBeen.get(position).getName();
    }
}
