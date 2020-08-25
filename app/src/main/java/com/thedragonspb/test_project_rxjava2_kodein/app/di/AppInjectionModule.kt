package com.thedragonspb.test_project_rxjava2_kodein.app.di

import com.thedragonspb.test_project_rxjava2_kodein.breed_images.di.BreedsImagesInjectionModule
import com.thedragonspb.test_project_rxjava2_kodein.breeds.di.BreedsInjectionModule
import org.kodein.di.Kodein

object AppInjectionModule {

    val module = Kodein.Module(AppInjectionModule.javaClass.name) {

        import(ApiInjectionModule.module)
        import(BreedsInjectionModule.module)
        import(BreedsImagesInjectionModule.module)

    }
}