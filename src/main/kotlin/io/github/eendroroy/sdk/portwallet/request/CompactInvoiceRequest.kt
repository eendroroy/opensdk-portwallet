package io.github.eendroroy.sdk.portwallet.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("invoice")
data class CompactInvoiceRequest(
    @JsonProperty("amount") var amount: Double? = null,
    @JsonProperty("customer_phone") var customerPhone: String? = null,
    @JsonProperty("currency") var currency: String? = null,
    @JsonProperty("customer_name") var customerName: String? = null,
    @JsonProperty("customer_email") var customerEmail: String? = null,
    @JsonProperty("reference") var reference: String? = null
): BaseRequest
