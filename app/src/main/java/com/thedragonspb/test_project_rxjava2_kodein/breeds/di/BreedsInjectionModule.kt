package com.thedragonspb.test_project_rxjava2_kodein.breeds.di

import com.thedragonspb.test_project_rxjava2_kodein.app.api.DogsApi
import com.thedragonspb.test_project_rxjava2_kodein.breeds.gateway.BreedsConverter
import com.thedragonspb.test_project_rxjava2_kodein.breeds.gateway.BreedsGateway
import com.thedragonspb.test_project_rxjava2_kodein.breeds.ui.BreedsViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

object BreedsInjectionModule {

    val module = Kodein.Module(BreedsInjectionModule.javaClass.name) {

        bind<BreedsViewModel>() with singleton {
            BreedsViewModel(instance())
        }

        bind<BreedsGateway>() with singleton {
            BreedsGateway(instance(), instance())
        }

        bind<BreedsConverter>() with singleton {
            BreedsConverter()
        }

    }

}