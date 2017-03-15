package test.narendra.com.androidpracticaltest.di.component;

import javax.inject.Singleton;

import dagger.Component;
import test.narendra.com.androidpracticaltest.di.module.AppModule;
import test.narendra.com.androidpracticaltest.mvp.MenuMVP;
import test.narendra.com.androidpracticaltest.ui.fragments.MenuListFragment;

/**
 * <h1>AppComponent, which list dependency modules and injection targets</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MenuListFragment target);

    void inject(MenuMVP.RequiredViewOps viewOps);
}

