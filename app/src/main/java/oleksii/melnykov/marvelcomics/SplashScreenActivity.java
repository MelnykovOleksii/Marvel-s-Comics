package oleksii.melnykov.marvelcomics;

import dagger.android.DaggerActivity;
import oleksii.melnykov.marvelcomics.main.MainActivity;

public class SplashScreenActivity extends DaggerActivity {

  @Override
  protected void onResume() {
    super.onResume();
    startActivity(MainActivity.createNewIntent(SplashScreenActivity.this));
    finish();
  }

}