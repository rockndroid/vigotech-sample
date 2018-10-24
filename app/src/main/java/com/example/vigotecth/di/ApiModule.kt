package com.example.vigotecth.di

import com.example.vigotecth.data.remote.VigoTechApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    private companion object {
        const val ENDPOINT = "https://vigotech-db.firebaseio.com/"
    }

    @Provides
    fun provideApi(client: OkHttpClient): VigoTechApi {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ENDPOINT)
            .client(client)
            .build()
            .create(VigoTechApi::class.java)

    }

    @Provides
    @Singleton
    fun provideApiClient(): OkHttpClient {
        return OkHttpClient()
    }
}