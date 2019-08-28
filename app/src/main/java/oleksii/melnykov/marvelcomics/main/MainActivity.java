package oleksii.melnykov.marvelcomics.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.DaggerActivity;
import javax.inject.Inject;
import oleksii.melnykov.marvelcomics.R;

public class MainActivity extends DaggerActivity implements MainContract.View {

  public static Intent createNewIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Inject
  MainContract.Presenter presenter;

  @BindView(R.id.activity_main_anim_logo)
  ImageView animLogo;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    AnimatedVectorDrawableCompat animatedVectorDrawable = AnimatedVectorDrawableCompat
        .create(this, R.drawable.load_vector_anim);
    animLogo.setImageDrawable(animatedVectorDrawable);
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.takeView(this);
  }

  @Override
  protected void onStart() {
    super.onStart();
    startAnimationDrawable(animLogo.getDrawable());
  }

  @Override
  protected void onStop() {
    super.onStop();
    stopAnimationDrawable(animLogo.getDrawable());
  }

  @Override
  protected void onPause() {
    super.onPause();
    presenter.dropView();
  }

  private void startAnimationDrawable(Drawable drawable) {
    if (drawable instanceof AnimatedVectorDrawableCompat) {
      AnimatedVectorDrawableCompat animatedVectorDrawable = ((AnimatedVectorDrawableCompat) drawable);
      animatedVectorDrawable.start();
      animatedVectorDrawable.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
        @Override
        public void onAnimationEnd(Drawable drawable) {
          super.onAnimationEnd(drawable);
          animatedVectorDrawable.start();
        }
      });
    } else {
      Log.e(this.getClass().getSimpleName(),
          "Error animation start - it`s not instanceof AnimatedVectorDrawableCompat");
    }
  }

  private void stopAnimationDrawable(Drawable drawable) {
    if (drawable instanceof AnimatedVectorDrawableCompat) {
      AnimatedVectorDrawableCompat animatedVectorDrawable = ((AnimatedVectorDrawableCompat) drawable);
      animatedVectorDrawable.clearAnimationCallbacks();
      animatedVectorDrawable.stop();
    } else {
      Log.e(this.getClass().getSimpleName(),
          "Error animation stop - it`s not instanceof AnimatedVectorDrawableCompat");
    }
  }

}
