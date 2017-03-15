package test.narendra.com.androidpracticaltest.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import test.narendra.com.androidpracticaltest.R;
import test.narendra.com.androidpracticaltest.app.MainApplication;
import test.narendra.com.androidpracticaltest.modal.MenuContentsModel;
import test.narendra.com.androidpracticaltest.ui.adapter.MenuAdapter;
import test.narendra.com.androidpracticaltest.ui.adapter.MenuItemDecoration;

/**
 * <h1>MenuListFragment</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class MenuListFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "pager_section_number";
    @Inject
    MenuContentsModel menuContentsModel;
    private RecyclerView mRecyclerView;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private TextView mTextPrice;

    public static MenuListFragment newInstance(int sectionNumber) {
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        MenuListFragment fragment = new MenuListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_list, container, false);
        MainApplication.getApp().getmAppComponent().inject(this);
        bindViews(view);
        return view;
    }

    private void bindViews(View view) {

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.list_menu_item);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mTextPrice = (TextView) getView().findViewById(R.id.text_price);
        mTextPrice.setText(Html.fromHtml("17" + "." + "<sup><small>" + "00" + "</small></sup>"));
        MenuAdapter adapter = new MenuAdapter(getActivity(), menuContentsModel.getMenuItems());
        mRecyclerView.setAdapter(adapter);
        MenuItemDecoration decoration = new MenuItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);

    }
}
