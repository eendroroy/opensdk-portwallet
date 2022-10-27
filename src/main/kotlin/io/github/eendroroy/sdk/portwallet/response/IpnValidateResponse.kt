package io.github.eendroroy.sdk.portwallet.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.response.nested.DataResponse
import io.github.eendroroy.sdk.portwallet.response.nested.ErrorResponse

/**
 * @author indrajit
 */
@JsonRootName("ipn")
data class IpnValidateResponse(
    @JsonProperty("result") var result: String? = null,
    @JsonProperty("data") var data: DataResponse? = null,
    @JsonProperty("error") var error: ErrorResponse? = null,
) : BaseResponse() {
    override fun httpResponseCode(code: Int) = this.apply { this.httpResponseCode = code }
    override fun httpResponseMessage(message: String) = apply { this.httpResponseMessage = message }
}
