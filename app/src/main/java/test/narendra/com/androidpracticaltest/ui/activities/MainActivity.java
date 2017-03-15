package test.narendra.com.androidpracticaltest.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import test.narendra.com.androidpracticaltest.R;
import test.narendra.com.androidpracticaltest.modal.MenuItemsModel;
import test.narendra.com.androidpracticaltest.mvp.MenuMVP;
import test.narendra.com.androidpracticaltest.mvp.Presentor;
import test.narendra.com.androidpracticaltest.ui.adapter.SubMenuTabsAdapter;
import test.narendra.com.androidpracticaltest.ui.adapter.TopMenuItemAdapter;
import test.narendra.com.androidpracticaltest.utils.ItemClickSupport;

/**
 * <h1>MainActivity</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class MainActivity extends AppCompatActivity implements MenuMVP.RequiredViewOps {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private RecyclerView mTopMenuLayout;

    //Sub menu adapter for tabs
    private SubMenuTabsAdapter mSectionsPagerAdapter;
    // top menu adapter
    private TopMenuItemAdapter mTopMenuItemAdapter;

    // prensetor for menus
    private MenuMVP.PresentorOps mPresentorOps;
    private MenuItemsModel menuItemsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        init();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        mViewPager = (ViewPager) findViewById(R.id.container);

        mTabLayout = (TabLayout) findViewById(R.id.tab_sab_menu_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_arrow));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTopMenuLayout = (RecyclerView) findViewById(R.id.tab_top_menu_layout);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mTopMenuLayout.setLayoutManager(layoutManager);
    }

    private void init() {
        mPresentorOps = new Presentor(this);
        mPresentorOps.getMenuItems();

        ItemClickSupport.addTo(mTopMenuLayout).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // for using color in top menu and toggle visibility on sub menu
                for (MenuItemsModel.TopMenuBean modal : menuItemsModel.getTopmenu()) {
                    modal.setSelected(false);
                }
                if (menuItemsModel.getTopmenu().get(position).getIssubmenu() == 1) {
                    mTabLayout.setVisibility(View.VISIBLE);
                } else {
                    mTabLayout.setVisibility(View.GONE);
                }
                menuItemsModel.getTopmenu().get(position).setSelected(true);
                mTopMenuItemAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showMenuItems(MenuItemsModel menuItems) {
        this.menuItemsModel = menuItems;
        menuItems.getTopmenu().get(0).setSelected(true);
        mSectionsPagerAdapter = new SubMenuTabsAdapter(getSupportFragmentManager(), menuItems.getSubmenu());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTopMenuItemAdapter = new TopMenuItemAdapter(MainActivity.this, menuItems.getTopmenu());
        mTopMenuLayout.setAdapter(mTopMenuItemAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
