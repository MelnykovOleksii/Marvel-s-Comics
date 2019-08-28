package oleksii.melnykov.marvelcomics.base;

import androidx.annotation.NonNull;

public interface BasePresenter<T> {
  void takeView(@NonNull T view);
  void dropView();
}
