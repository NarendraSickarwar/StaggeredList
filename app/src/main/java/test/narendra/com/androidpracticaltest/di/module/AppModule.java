package test.narendra.com.androidpracticaltest.di.module;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import dagger.Module;
import dagger.Provides;
import test.narendra.com.androidpracticaltest.modal.MenuContentsModel;

/**
 * <h1>AppModule, providing dependencies using Dagger</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

@Module
public class AppModule {

    private Context mCtx;

    public AppModule(Context context) {
        this.mCtx = context;
    }

    @Provides
    MenuContentsModel getMovieHelper() {
        Gson gson = new Gson();
        MenuContentsModel menuContentsModel = null;
        try {
            menuContentsModel = gson.fromJson(loadJSONFromAsset(), MenuContentsModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuContentsModel;
    }

    /**
     * <p>Reads json from assets for menu_contents.json</p>
     *
     * @return JSON String for menu_contents.json
     */
    private String loadJSONFromAsset() {
        String json = null;
        InputStream is = null;
        try {
            is = mCtx.getAssets().open("menu_contents.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
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
