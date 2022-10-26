package io.github.eendroroy.sdk.portwallet.response.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.response.BaseResponse

/**
 * @author indrajit
 */
@JsonRootName("refund")
data class RefundResponse(
    @JsonProperty("amount") var amount: Double? = null,
    @JsonProperty("status") var status: String? = null,
) : BaseResponse
