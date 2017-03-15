package test.narendra.com.androidpracticaltest.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <h1>MenuItemDecoration, {@link android.support.v7.widget.RecyclerView.ItemDecoration} for menu recycler view</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class MenuItemDecoration extends RecyclerView.ItemDecoration {

    private final int mSpace;

    public MenuItemDecoration(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;

        outRect.top = mSpace;
    }
}