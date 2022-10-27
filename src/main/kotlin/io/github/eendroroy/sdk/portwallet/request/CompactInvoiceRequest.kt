package io.github.eendroroy.sdk.portwallet.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("invoice")
data class CompactInvoiceRequest(
    @field:JsonProperty("amount") var amount: Double? = null,
    @field:JsonProperty("customer_phone") var customerPhone: String? = null,
    @field:JsonProperty("currency") var currency: String? = null,
    @field:JsonProperty("customer_name") var customerName: String? = null,
    @field:JsonProperty("customer_email") var customerEmail: String? = null,
    @field:JsonProperty("reference") var reference: String? = null
) : BaseRequest
