package oleksii.melnykov.marvelcomics.di;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import oleksii.melnykov.marvelcomics.App;
import oleksii.melnykov.marvelcomics.data.DataModule;

@AppScope
@Component(
    modules = {
        AndroidInjectionModule.class,
        ActivitiesModule.class,
        DataModule.class
    })
public interface AppComponent extends AndroidInjector<App> {

  @Component.Factory
  interface Factory {

    AppComponent create(@BindsInstance App app);
  }

}
