package io.github.eendroroy.sdk.portwallet.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.response.nested.DataResponse
import io.github.eendroroy.sdk.portwallet.response.nested.ErrorResponse

/**
 * @author indrajit
 */
@JsonRootName("retrieve_invoice")
data class RetrieveInvoiceResponse(
    @JsonProperty("result") var result: String? = null,
    @JsonProperty("data") var data: DataResponse? = null,
    @JsonProperty("error") var error: ErrorResponse? = null,
) : BaseResponse {
    var responseCode: String? = null
    var responseMessage: String? = null
}
