package test.narendra.com.androidpracticaltest.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import test.narendra.com.androidpracticaltest.modal.MenuItemsModel;

/**
 * <h1>AssetsReader, Reads files from assets</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class AssetsReader {
    private static AssetsReader sInstance = null;
    private AssetManager mAssetManager;


    private AssetsReader(Context context) {
        mAssetManager = context.getAssets();
    }

    public static void init(Context context) {
        if (sInstance == null) {
            sInstance = new AssetsReader(context);
        }
    }

    public static AssetsReader getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException("call init before getting instance");
        }
        return sInstance;
    }

    public MenuItemsModel getMenuItems() {
        String json = loadJSONFromAsset("menu_items.json");
        if (json == null) {
            return null;
        }
        return new Gson().fromJson(json, MenuItemsModel.class);
    }

    private String loadJSONFromAsset(String fileName) {
        String json = null;
        InputStream is = null;
        try {
            is = mAssetManager.open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }
}
