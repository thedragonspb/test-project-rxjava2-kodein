package com.thedragonspb.test_project_rxjava2_kodein.app.api

import com.google.gson.annotations.SerializedName

class BreedsResponse {

    @SerializedName("message")
    var breeds: HashMap<String, List<String>>? = null

    @SerializedName("status")
    var status: String? = null
}