package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("order")
data class OrderRequest(
    @JsonProperty("amount") var amount: Double? = null,
    @JsonProperty("currency") var currency: String? = null,
    @JsonProperty("redirect_url") var redirectUrl: String? = null,
    @JsonProperty("ipn_url") var ipnUrl: String? = null,
    @JsonProperty("reference") var reference: String? = null,
)
