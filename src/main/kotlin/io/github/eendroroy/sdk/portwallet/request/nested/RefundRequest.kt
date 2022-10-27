package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("refund")
data class RefundRequest(
    @field:JsonProperty("amount") var amount: Int? = null,
    @field:JsonProperty("currency") var currency: String? = null,
)
