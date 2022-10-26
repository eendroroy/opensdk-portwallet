package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("billing")
data class BillingRequest(
    @JsonProperty("customer") var customer: CustomerRequest? = null,
)
