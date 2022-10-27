package io.github.eendroroy.sdk.portwallet.endpoint

import io.github.eendroroy.sdk.portwallet.request.InvoiceRequest
import io.github.eendroroy.sdk.portwallet.request.RefundInvoiceRequest
import io.github.eendroroy.sdk.portwallet.response.InvoiceResponse
import io.github.eendroroy.sdk.portwallet.response.IpnValidateResponse
import io.github.eendroroy.sdk.portwallet.response.RefundInvoiceResponse
import io.github.eendroroy.sdk.portwallet.response.RetrieveInvoiceResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * @author indrajit
 */
internal interface PWEndpoints {
    @POST("/payment/v2/invoice")
    fun createInvoice(
        @HeaderMap headers: Map<String?, String?>?,
        @Body request: InvoiceRequest?
    ): Call<InvoiceResponse>?

    @GET("/payment/v2/invoice/ipn/{invoiceId}/{amount}")
    fun ipnValidate(
        @HeaderMap headers: Map<String?, String?>?,
        @Path("invoiceId") invoiceId: String?,
        @Path("amount") amount: Double?
    ): Call<IpnValidateResponse>?

    @GET("/payment/v2/invoice/{invoiceId}")
    fun retrieveInvoice(
        @HeaderMap headers: Map<String?, String?>?,
        @Path("invoiceId") invoiceId: String?
    ): Call<RetrieveInvoiceResponse>?

    @POST("/payment/v2/invoice/refund/{invoiceId}")
    fun refundInvoice(
        @HeaderMap headers: Map<String?, String?>?,
        @Body request: RefundInvoiceRequest?,
        @Path("invoiceId") invoiceId: String?
    ): Call<RefundInvoiceResponse>?
}
