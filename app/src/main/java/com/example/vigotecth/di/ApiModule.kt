package com.example.vigotecth.di

import com.example.vigotecth.data.remote.VigoTechApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

  @Provides
  fun provideApi(
      client: OkHttpClient,
      @Named("base_endpoint") endpoint: String
  ): VigoTechApi {

    return Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(endpoint)
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