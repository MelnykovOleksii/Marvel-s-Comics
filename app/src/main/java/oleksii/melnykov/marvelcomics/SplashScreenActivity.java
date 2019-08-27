package oleksii.melnykov.marvelcomics;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;
import oleksii.melnykov.marvelcomics.main.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        runOnUiThread(new TimerTask() {
          @Override
          public void run() {
            startActivity(MainActivity.createNewIntent(SplashScreenActivity.this));
          }
        });
      }
    }, 3000);

  }

}