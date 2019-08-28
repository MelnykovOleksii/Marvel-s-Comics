package oleksii.melnykov.marvelcomics.main.di;


import dagger.Module;
import dagger.Provides;
import oleksii.melnykov.marvelcomics.data.Repository;
import oleksii.melnykov.marvelcomics.main.MainContract;
import oleksii.melnykov.marvelcomics.main.MainPresenter;

@Module
public class MainModule {

  @Provides
  @MainScope
  MainContract.Presenter provideMainPresenter(Repository repository) {
    return new MainPresenter(repository);
  }

}
