package com.thedragonspb.test_project_rxjava2_kodein.breeds.gateway

import com.thedragonspb.test_project_rxjava2_kodein.app.api.BreedsResponse
import com.thedragonspb.test_project_rxjava2_kodein.breeds.ui.adapter.Breed

class BreedsConverter {

    fun fromNetwork(breedsResponse: BreedsResponse) : List<Breed> {
        val breedsList = arrayListOf<Breed>()
        breedsResponse.breeds?.map { entry ->
            breedsList.add(Breed(entry.key, entry.value))
        }
        return breedsList
    }
}