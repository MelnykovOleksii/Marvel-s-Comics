package oleksii.melnykov.marvelcomics.data;


import dagger.Module;
import dagger.Provides;
import oleksii.melnykov.marvelcomics.App;
import oleksii.melnykov.marvelcomics.di.AppScope;

@Module
public class DataModule {

  @AppScope
  @Provides
  Repository provideRepository(App app) {
    return new Repository(app);
  }

}
