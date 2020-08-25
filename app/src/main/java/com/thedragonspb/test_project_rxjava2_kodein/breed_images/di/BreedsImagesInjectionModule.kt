package com.thedragonspb.test_project_rxjava2_kodein.breed_images.di

import com.thedragonspb.test_project_rxjava2_kodein.breed_images.gateway.BreedImagesConverter
import com.thedragonspb.test_project_rxjava2_kodein.breed_images.gateway.BreedImagesGateway
import com.thedragonspb.test_project_rxjava2_kodein.breed_images.ui.BreedImagesViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

object BreedsImagesInjectionModule {

    val module = Kodein.Module(BreedsImagesInjectionModule.javaClass.name) {

        bind<BreedImagesViewModel>() with singleton {
            BreedImagesViewModel(instance())
        }

        bind<BreedImagesGateway>() with singleton {
            BreedImagesGateway(instance(), instance())
        }

        bind<BreedImagesConverter>() with singleton {
            BreedImagesConverter()
        }

    }

}