package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("customer")
data class CustomerRequest(
    @JsonProperty("name") var name: String? = null,
    @JsonProperty("email") var email: String? = null,
    @JsonProperty("phone") var phone: String? = null,
    @JsonProperty("address") var address: AddressRequest? = null,
)
