package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("shipping")
data class ShippingRequest(
    @JsonProperty("customer") var customer: CustomerRequest? = null,
)
