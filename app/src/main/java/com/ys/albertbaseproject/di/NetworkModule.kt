package com.ys.albertbaseproject.di

import android.content.Context

import com.ys.albertbaseproject.BuildConfig
import com.ys.albertbaseproject.network.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {
//    @Provides
//    @Singleton
//    fun provideOkHttpCache(context: Context): Cache {
//        val cacheSize = 10 * 1024 * 1024 // 10MB
//        return Cache(context.cacheDir, cacheSize.toLong())
//    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()

        clientBuilder
//            .cache(cache)
            .addInterceptor(httpLoggingInterceptor)

        return clientBuilder.build()
    }

    @Provides
    @Singleton
    @Named("RETROFIT_API")
    fun provideApiRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideApiService(@Named("RETROFIT_API") retrofitPayment: Retrofit): ApiService {
        return retrofitPayment.create(ApiService::class.java)
    }
}