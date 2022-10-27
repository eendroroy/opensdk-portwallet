package io.github.eendroroy.sdk.portwallet.request

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.request.nested.RefundRequest

/**
 * @author indrajit
 */
@JsonRootName("invoice")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class RefundInvoiceRequest(
    @field:JsonProperty("refund") var refund: RefundRequest? = null,
) : BaseRequest
