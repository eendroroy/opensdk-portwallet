package io.github.eendroroy.sdk.portwallet.response.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.response.BaseResponse

/**
 * @author indrajit
 */
@JsonRootName("transaction")
data class TransactionResponse(
    @JsonProperty("amount") var amount: String? = null,
    @JsonProperty("currency") var currency: String? = null,
    @JsonProperty("status") var status: String? = null,
    @JsonProperty("type") var type: String? = null,
    @JsonProperty("time") var time: String? = null,
) : BaseResponse() {
    override fun httpResponseCode(code: Int) = this.apply { this.httpResponseCode = code }
    override fun httpResponseMessage(message: String) = apply { this.httpResponseMessage = message }
}
