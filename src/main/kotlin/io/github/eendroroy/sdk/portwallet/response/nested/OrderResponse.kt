package io.github.eendroroy.sdk.portwallet.response.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.response.BaseResponse

/**
 * @author indrajit
 */
@JsonRootName("order")
data class OrderResponse(
    @JsonProperty("invoice") var invoice: String? = null,
    @JsonProperty("amount") var amount: Double? = null,
    @JsonProperty("currency") var currency: String? = null,
    @JsonProperty("type") var type: String? = null,
    @JsonProperty("has_emi") var hasEmi: Int? = null,
    @JsonProperty("has_discount") var hasDiscount: Int? = null,
    @JsonProperty("discount_availed") var discountAvailed: Int? = null,
    @JsonProperty("is_recurring_payment") var isRecurringPayment: Int? = null,
    @JsonProperty("redirect_url") var redirectUrl: String? = null,
    @JsonProperty("created_at") var createdAt: String? = null,
    @JsonProperty("status") var status: String? = null,
    @JsonProperty("emi") var emi: EmiResponse? = null,
) : BaseResponse
