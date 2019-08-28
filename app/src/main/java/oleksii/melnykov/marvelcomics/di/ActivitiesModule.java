package oleksii.melnykov.marvelcomics.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import oleksii.melnykov.marvelcomics.SplashScreenActivity;
import oleksii.melnykov.marvelcomics.main.MainActivity;
import oleksii.melnykov.marvelcomics.main.di.MainModule;
import oleksii.melnykov.marvelcomics.main.di.MainScope;

@Module
public abstract class ActivitiesModule {

  @ContributesAndroidInjector()
  abstract SplashScreenActivity bindSplashScreenActivity();

  @MainScope
  @ContributesAndroidInjector(modules = MainModule.class)
  abstract MainActivity bindMainActivity();

}
