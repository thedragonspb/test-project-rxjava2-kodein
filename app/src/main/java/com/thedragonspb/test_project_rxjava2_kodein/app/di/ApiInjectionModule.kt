package com.thedragonspb.test_project_rxjava2_kodein.app.di

import com.thedragonspb.test_project_rxjava2_kodein.app.api.DogsApi
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiInjectionModule {

    val module = Kodein.Module(ApiInjectionModule.javaClass.name) {

        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        bind<DogsApi>() with singleton {
            val retrofit: Retrofit = instance()
            retrofit.create(DogsApi::class.java)
        }
    }

}