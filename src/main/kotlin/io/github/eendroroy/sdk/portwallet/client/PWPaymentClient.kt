package io.github.eendroroy.sdk.portwallet.client

import io.github.eendroroy.sdk.portwallet.config.PWAuthProvider
import io.github.eendroroy.sdk.portwallet.config.PWConfiguration
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
class PWPaymentClient(
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
    fun createInvoice(request: InvoiceRequest?): InvoiceResponse {
        val response: InvoiceResponse
        val apiResponse: Response<InvoiceResponse> = endpoints.createInvoice(headers, request)!!.execute()
        response = if (apiResponse.isSuccessful) {
            apiResponse.body()!!
        } else if (null == apiResponse.errorBody()) {
            throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
        } else if (0L == apiResponse.errorBody()!!.contentLength()) {
            throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
        } else {
            val errorConverter = retrofit.responseBodyConverter<InvoiceResponse>(
                InvoiceResponse::class.java, arrayOfNulls(0)
            )
            apiResponse.errorBody()?.let { errorConverter.convert(it) }!!
        }
        response.responseCode = apiResponse.code().toString()
        response.responseMessage = apiResponse.message()
        return response
    }

    @Throws(Exception::class)
    fun ipnValidate(invoiceId: String?, amount: Double?): IpnValidateResponse {
        val response: IpnValidateResponse
        val apiResponse: Response<IpnValidateResponse> = endpoints.ipnValidate(headers, invoiceId, amount)!!
            .execute()
        response = if (apiResponse.isSuccessful) {
            apiResponse.body()!!
        } else if (null == apiResponse.errorBody()) {
            throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
        } else if (0L == apiResponse.errorBody()!!.contentLength()) {
            throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
        } else {
            val errorConverter = retrofit.responseBodyConverter<IpnValidateResponse>(
                IpnValidateResponse::class.java, arrayOfNulls(0)
            )
            apiResponse.errorBody()?.let { errorConverter.convert(it) }!!
        }
        response.responseCode = apiResponse.code().toString()
        response.responseMessage = apiResponse.message()
        return response
    }

    @Throws(Exception::class)
    fun retrieveInvoice(invoiceId: String?): RetrieveInvoiceResponse {
        val response: RetrieveInvoiceResponse
        val apiResponse: Response<RetrieveInvoiceResponse> = endpoints.retrieveInvoice(headers, invoiceId)!!
            .execute()
        if (apiResponse.isSuccessful) {
            response = apiResponse.body()!!
        } else if (null == apiResponse.errorBody()) {
            throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
        } else if (0L == apiResponse.errorBody()!!.contentLength()) {
            throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
        } else {
            val errorConverter = retrofit.responseBodyConverter<RetrieveInvoiceResponse>(
                RetrieveInvoiceResponse::class.java, arrayOfNulls(0)
            )
            response = apiResponse.errorBody()?.let { errorConverter.convert(it) }!!
        }
        response.responseCode = apiResponse.code().toString()
        response.responseMessage = apiResponse.message()
        return response
    }

    @Throws(Exception::class)
    fun refundInvoice(request: RefundInvoiceRequest?, invoiceId: String?): RefundInvoiceResponse {
        val response: RefundInvoiceResponse
        val apiResponse: Response<RefundInvoiceResponse> = endpoints.refundInvoice(headers, request, invoiceId)!!
            .execute()
        response = if (apiResponse.isSuccessful) {
            apiResponse.body()!!
        } else if (null == apiResponse.errorBody()) {
            throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
        } else if (0L == apiResponse.errorBody()!!.contentLength()) {
            throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
        } else {
            val errorConverter = retrofit.responseBodyConverter<RefundInvoiceResponse>(
                RefundInvoiceResponse::class.java, arrayOfNulls(0)
            )
            apiResponse.errorBody()?.let { errorConverter.convert(it) }!!
        }
        response.responseCode = apiResponse.code().toString()
        response.responseMessage = apiResponse.message()
        return response
    }
}
