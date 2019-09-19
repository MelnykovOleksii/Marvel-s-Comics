package oleksii.melnykov.marvelcomics.data;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import oleksii.melnykov.marvelcomics.BuildConfig;
import oleksii.melnykov.marvelcomics.di.AppScope;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

  @AppScope
  @Provides
  Repository provideRepository() {
    return new Repository();
  }

  private Retrofit buildRetrofit() {
    Gson gson = new GsonBuilder().create();
    GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
    return new Retrofit.Builder()
        .baseUrl(BuildConfig.MarvelApiUrl)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(gsonConverterFactory)
        .client(new OkHttpClient().newBuilder().build())
        .build();
  }

}
