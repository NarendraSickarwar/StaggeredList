package test.narendra.com.androidpracticaltest.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.narendra.com.androidpracticaltest.R;
import test.narendra.com.androidpracticaltest.modal.MenuItemsModel;

/**
 * <h1>TopMenuItemAdapter</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class TopMenuItemAdapter extends RecyclerView.Adapter<TopMenuItemAdapter.ViewHolder> {

    private final Context context;
    private List<MenuItemsModel.TopMenuBean> mItems = new ArrayList<>();

    public TopMenuItemAdapter(Context context, List<MenuItemsModel.TopMenuBean> items) {
        this.mItems = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_menu_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textview_tittle.setText(mItems.get(position).getName());
        if (mItems.get(position).isSelected()) {
            holder.textview_tittle.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        } else {
            holder.textview_tittle.setTextColor(context.getResources().getColor(R.color.black));
        }

    }


    @Override
    public int getItemCount() {
        if (mItems != null) {
            return mItems.size();
        }
        return 0;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textview_tittle;

        ViewHolder(View itemView) {
            super(itemView);
            textview_tittle = (TextView) itemView.findViewById(R.id.textview_tittle);

        }
    }
}