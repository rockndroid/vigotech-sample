package com.example.vigotecth.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class EndpointModule {

  @Provides
  @Named("base_endpoint")
  fun provideEndpoint(): String {
    return "http://localhost:8080/"
  }
}
