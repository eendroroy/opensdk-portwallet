package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("address")
data class AddressRequest(
    @field:JsonProperty("street") var street: String = "Dhaka",
    @field:JsonProperty("city") var city: String = "Dhaka",
    @field:JsonProperty("state") var state: String = "Dhaka",
    @field:JsonProperty("zipcode") var zipCode: String = "1200",
    @field:JsonProperty("country") var country: String = "BD",
)
