package io.github.eendroroy.sdk.portwallet.request

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.request.nested.BillingRequest
import io.github.eendroroy.sdk.portwallet.request.nested.DiscountRequest
import io.github.eendroroy.sdk.portwallet.request.nested.EmiRequest
import io.github.eendroroy.sdk.portwallet.request.nested.OrderRequest
import io.github.eendroroy.sdk.portwallet.request.nested.ProductRequest
import io.github.eendroroy.sdk.portwallet.request.nested.ShippingRequest

/**
 * @author indrajit
 */
@JsonRootName("invoice")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InvoiceRequest(
    @JsonProperty("order") var order: OrderRequest? = null,
    @JsonProperty("product") var product: ProductRequest? = null,
    @JsonProperty("billing") var billing: BillingRequest? = null,
    @JsonProperty("shipping") var shipping: ShippingRequest? = null,
    @JsonProperty("discount") var discount: DiscountRequest? = null,
    @JsonProperty("emi") var emi: EmiRequest? = null,
    @JsonProperty("customs") var customs: List<Map<String, String>>? = null,
)
