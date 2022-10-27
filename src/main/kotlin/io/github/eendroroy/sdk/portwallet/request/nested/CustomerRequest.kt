package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("customer")
data class CustomerRequest(
    @field:JsonProperty("name") var name: String? = null,
    @field:JsonProperty("email") var email: String? = null,
    @field:JsonProperty("phone") var phone: String? = null,
    @field:JsonProperty("address") var address: AddressRequest? = null,
)
