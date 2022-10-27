package io.github.eendroroy.sdk.portwallet.response.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.response.BaseResponse
import lombok.Getter
import lombok.Setter
import lombok.ToString

/**
 * @author indrajit
 */
@ToString
@Setter
@Getter
@JsonRootName("data")
data class DataResponse(
    @JsonProperty("invoice_id") var invoiceId: String? = null,
    @JsonProperty("reference") var reference: String? = null,
    @JsonProperty("order") var order: OrderResponse? = null,
    @JsonProperty("product") var product: ProductResponse? = null,
    @JsonProperty("billing") var billing: BillingResponse? = null,
    @JsonProperty("shipping") var shipping: ShippingResponse? = null,
    @JsonProperty("refund") var refund: RefundResponse? = null,
    @JsonProperty("action") var action: ActionResponse? = null,
    @JsonProperty("transactions") var transactions: List<TransactionResponse>? = null,
    @JsonProperty("customs") var customs: List<Map<String, Any>>? = null,
) : BaseResponse() {
    override fun httpResponseCode(code: Int) = this.apply { this.httpResponseCode = code }
    override fun httpResponseMessage(message: String) = apply { this.httpResponseMessage = message }
}
