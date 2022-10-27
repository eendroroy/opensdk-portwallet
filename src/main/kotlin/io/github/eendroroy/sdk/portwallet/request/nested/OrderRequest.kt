package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("order")
data class OrderRequest(
    @field:JsonProperty("amount") var amount: Double? = null,
    @field:JsonProperty("currency") var currency: String? = null,
    @field:JsonProperty("redirect_url") var redirectUrl: String? = null,
    @field:JsonProperty("ipn_url") var ipnUrl: String? = null,
    @field:JsonProperty("reference") var reference: String? = null,
)
