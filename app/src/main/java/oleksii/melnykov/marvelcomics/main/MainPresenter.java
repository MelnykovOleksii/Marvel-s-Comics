package oleksii.melnykov.marvelcomics.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import oleksii.melnykov.marvelcomics.data.Repository;

public class MainPresenter implements MainContract.Presenter {

  @Nullable private MainContract.View view;
  private final Repository repository;

  public MainPresenter(Repository repository) {
    this.repository = repository;
  }

  @Override
  public void takeView(@NonNull MainContract.View view) {
    this.view = view;
  }

  @Override
  public void dropView() {
    view = null;
  }

}
