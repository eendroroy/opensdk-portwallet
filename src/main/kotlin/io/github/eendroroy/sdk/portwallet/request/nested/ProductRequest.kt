package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("product")
data class ProductRequest(
    @field:JsonProperty("name") var name: String = "Payment",
    @field:JsonProperty("description") var description: String = "Payment",
)
