package test.narendra.com.androidpracticaltest.app;

import android.app.Application;

import test.narendra.com.androidpracticaltest.di.component.AppComponent;
import test.narendra.com.androidpracticaltest.di.component.DaggerAppComponent;
import test.narendra.com.androidpracticaltest.di.module.AppModule;
import test.narendra.com.androidpracticaltest.utils.AssetsReader;

/**
 * <h1>Application class to initialize and maintain global app components</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

public class MainApplication extends Application {

    private static MainApplication sApp;
    private AppComponent mAppComponent;

    /**
     * @return Application class instance
     */
    public static MainApplication getApp() {
        return sApp;
    }

    /**
     * <p>This will run when app starts. Initialize all global objects here.</p>
     */
    @Override
    public void onCreate() {
        super.onCreate();

        getmAppComponent();
        sApp = this;

        AssetsReader.init(this);
    }

    /**
     * <p>Initialize and return dagger app compoment</p>
     *
     * @return Dagger AppComponent
     * @see AppComponent
     */
    public AppComponent getmAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(getApplicationContext())).build();
        }
        return mAppComponent;
    }
}