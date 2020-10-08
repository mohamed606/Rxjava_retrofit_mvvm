package com.example.rxjavawithretro.module;

import com.example.rxjavawithretro.data.PostApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public abstract class AppModule {

    @Singleton
    @Provides
    public static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(PostApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public static PostApi providePostApi(Retrofit retrofit) {
        return retrofit.create(PostApi.class);
    }
}
