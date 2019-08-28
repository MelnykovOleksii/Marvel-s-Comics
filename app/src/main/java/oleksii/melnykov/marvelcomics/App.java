package oleksii.melnykov.marvelcomics;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import oleksii.melnykov.marvelcomics.di.DaggerAppComponent;

public class App extends DaggerApplication {

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerAppComponent.factory().create(this);
  }

}
