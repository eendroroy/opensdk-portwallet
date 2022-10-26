package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("address")
data class AddressRequest(
    @JsonProperty("street") var street: String = "Dhaka",
    @JsonProperty("city") var city: String = "Dhaka",
    @JsonProperty("state") var state: String = "Dhaka",
    @JsonProperty("zipcode") var zipCode: String = "1200",
    @JsonProperty("country") var country: String = "BD",
)
