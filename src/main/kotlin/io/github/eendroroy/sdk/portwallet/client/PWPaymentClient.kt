package io.github.eendroroy.sdk.portwallet.client

import io.github.eendroroy.sdk.portwallet.config.PWAuthProvider
import io.github.eendroroy.sdk.portwallet.config.PWConfiguration
import io.github.eendroroy.sdk.portwallet.converter.ResponseConverter
import io.github.eendroroy.sdk.portwallet.endpoint.PWEndpoints
import io.github.eendroroy.sdk.portwallet.request.InvoiceRequest
import io.github.eendroroy.sdk.portwallet.request.RefundInvoiceRequest
import io.github.eendroroy.sdk.portwallet.response.InvoiceResponse
import io.github.eendroroy.sdk.portwallet.response.IpnValidateResponse
import io.github.eendroroy.sdk.portwallet.response.RefundInvoiceResponse
import io.github.eendroroy.sdk.portwallet.response.RetrieveInvoiceResponse
import retrofit2.Response
import retrofit2.Retrofit

/**
 * @author indrajit
 */
internal class PWPaymentClient(
    private val retrofit: Retrofit,
    private val configuration: PWConfiguration,
    private val authProvider: PWAuthProvider
) : PWClient {
    private val endpoints: PWEndpoints = retrofit.create(PWEndpoints::class.java)

    private val headers: HashMap<String?, String?>
        get() {
            val headers = HashMap<String?, String?>()
            headers["Content-Type"] = configuration.contentType
            headers["Accept"] = configuration.accept
            headers["Authorization"] = authProvider.authorization
            return headers
        }

    @Throws(Exception::class)
    override fun createInvoice(request: InvoiceRequest): InvoiceResponse? {
        val apiResponse: Response<InvoiceResponse> = endpoints.createInvoice(headers, request)!!.execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    override fun ipnValidate(invoiceId: String, amount: Double): IpnValidateResponse? {
        val apiResponse: Response<IpnValidateResponse> = endpoints.ipnValidate(headers, invoiceId, amount)!!.execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    override fun retrieveInvoice(invoiceId: String?): RetrieveInvoiceResponse? {
        val apiResponse: Response<RetrieveInvoiceResponse> = endpoints.retrieveInvoice(headers, invoiceId)!!.execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    override fun refundInvoice(request: RefundInvoiceRequest, invoiceId: String): RefundInvoiceResponse? {
        val apiResponse: Response<RefundInvoiceResponse> = endpoints.refundInvoice(headers, request, invoiceId)!!
            .execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }
}
