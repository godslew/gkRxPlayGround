package com.godslew.gkrxplayground.di.module

import android.app.Application
import com.godslew.gkrxplayground.MainActivity
import com.godslew.gkrxplayground.client.GitHubClient
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(
    private val application : Application
)
{
    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    fun provideRetrofitV(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideDesiredProfileService(
        retrofit: Retrofit
    ): GitHubClient.GitHubService {
        return retrofit.create(GitHubClient.GitHubService::class.java)
    }

}