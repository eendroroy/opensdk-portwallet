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
 *
 * Invoice Request Body:
 *
 * {
 *   "order" : {
 *     "amount" : 100.0,
 *     "currency" : "BDT",
 *     "redirect_url" : "https://example.con/redirect",
 *     "ipn_url" : "https://example.con/ipn",
 *     "reference" : "MY_REFERENCE"
 *   },
 *   "product" : {
 *     "name" : "MY_PRODUCT",
 *     "description" : "It's My Product"
 *   },
 *   "billing" : {
 *     "customer" : {
 *       "name" : "Customer Name",
 *       "email" : "customer@example.com",
 *       "phone" : "8801800000000",
 *       "address" : {
 *         "street" : "Dhaka",
 *         "city" : "Dhaka",
 *         "state" : "Dhaka",
 *         "zipcode" : "1200",
 *         "country" : "BD"
 *       }
 *     }
 *   },
 *   "shipping" : {
 *     "customer" : {
 *       "name" : "Customer Name",
 *       "email" : "customer@example.com",
 *       "phone" : "8801800000000",
 *       "address" : {
 *         "street" : "Dhaka",
 *         "city" : "Dhaka",
 *         "state" : "Dhaka",
 *         "zipcode" : "1200",
 *         "country" : "BD"
 *       }
 *     }
 *   },
 *   "discount" : {
 *     "enable" : 1,
 *     "codes" : [ "MyCode1", "MyCode2" ]
 *   },
 *   "emi" : {
 *     "enable" : 1,
 *     "tenures" : [ 3, 6, 9, 12, 24, 36 ]
 *   },
 *   "customs" : [
 *     { "property1" : "value1" },
 *     { "property1" : "value1" }
 *   ]
 * }
 *
 * @author indrajit
 */
@JsonRootName("invoice")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InvoiceRequest(
    @field:JsonProperty("order") var order: OrderRequest? = null,
    @field:JsonProperty("product") var product: ProductRequest? = null,
    @field:JsonProperty("billing") var billing: BillingRequest? = null,
    @field:JsonProperty("shipping") var shipping: ShippingRequest? = null,
    @field:JsonProperty("discount") var discount: DiscountRequest? = null,
    @field:JsonProperty("emi") var emi: EmiRequest? = null,
    @field:JsonProperty("customs") var customs: List<Map<String, String>>? = null,
) : BaseRequest
