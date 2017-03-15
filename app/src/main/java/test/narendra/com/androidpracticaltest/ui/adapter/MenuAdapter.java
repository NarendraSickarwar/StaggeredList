package test.narendra.com.androidpracticaltest.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import test.narendra.com.androidpracticaltest.R;
import test.narendra.com.androidpracticaltest.modal.MenuContentsModel;
import test.narendra.com.androidpracticaltest.ui.views.PinkDotView;

/**
 * <h1>MenuAdapter</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    public static int sCounter;
    private Context context;
    private List<MenuContentsModel.MenuItemBean> mMenuItemBeanList;

    public MenuAdapter(Context context, List<MenuContentsModel.MenuItemBean> menuItemBeanList) {
        this.context = context;
        this.mMenuItemBeanList = menuItemBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.imageView.setImageResource(getCardId(mMenuItemBeanList.get(position).getImagePath()));
        holder.textView.setText(mMenuItemBeanList.get(position).getItemName());
        String ss[] = mMenuItemBeanList.get(position).getItemPrice().split("\\.");
        holder.text_price.setText(Html.fromHtml(ss[0] + "." + "<sup><small>" + ss[1] + "</small></sup>"));
        holder.text_description.setText(mMenuItemBeanList.get(position).getDescription());

        holder.pink_dotview.setDotCount(mMenuItemBeanList.get(position).getItemCount());
        holder.layout_mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sCounter > 1000)
                    sCounter = 0;
                sCounter++;
                holder.button_menu_count.setText("" + sCounter);
            }
        });
        if (position == mMenuItemBeanList.size() - 1) {
            holder.layout_mainlayout.setPadding(0, 0, 0, 160);
        } else {
            holder.layout_mainlayout.setPadding(0, 0, 0, 0);
        }
        if (mMenuItemBeanList.get(position).getCartItem() == 0) {
            holder.button_menu_count.setVisibility(View.GONE);
        } else {
            holder.button_menu_count.setVisibility(View.VISIBLE);
            holder.button_menu_count.setText("" + mMenuItemBeanList.get(position).getCartItem());
        }
    }

    @Override
    public int getItemCount() {
        if (mMenuItemBeanList != null) {
            return mMenuItemBeanList.size();
        }
        return 0;
    }

    public int getCardId(String name) {
        Resources resources = context.getResources();

        return resources.getIdentifier(name, "drawable",
                context.getPackageName());

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView, text_description, text_price, button_menu_count;
        PinkDotView pink_dotview;
        RelativeLayout layout_mainlayout;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.img_food);
            textView = (TextView) itemView.findViewById(R.id.text_tittle);
            pink_dotview = (PinkDotView) itemView.findViewById(R.id.pink_dotview);
            layout_mainlayout = (RelativeLayout) itemView.findViewById(R.id.layout_mainlayout);
            text_description = (TextView) itemView.findViewById(R.id.text_description);
            text_price = (TextView) itemView.findViewById(R.id.text_price);
            button_menu_count = (TextView) itemView.findViewById(R.id.button_menu_count);

        }
    }
}
