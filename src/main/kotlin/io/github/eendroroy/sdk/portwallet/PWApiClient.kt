package io.github.eendroroy.sdk.portwallet

import io.github.eendroroy.sdk.portwallet.client.PWPaymentClient
import io.github.eendroroy.sdk.portwallet.client.UnsafeOkHttpClientBuilder.unsafeOkHttpClientBuilder
import io.github.eendroroy.sdk.portwallet.config.DefaultPWAuthProvider
import io.github.eendroroy.sdk.portwallet.config.PWAuthProvider
import io.github.eendroroy.sdk.portwallet.config.PWConfiguration
import io.github.eendroroy.sdk.portwallet.interceptor.DefaultPWInterceptor
import io.github.eendroroy.sdk.portwallet.interceptor.PWInterceptor
import io.github.eendroroy.sdk.portwallet.request.InvoiceRequest
import io.github.eendroroy.sdk.portwallet.request.RefundInvoiceRequest
import io.github.eendroroy.sdk.portwallet.response.InvoiceResponse
import io.github.eendroroy.sdk.portwallet.response.IpnValidateResponse
import io.github.eendroroy.sdk.portwallet.response.RefundInvoiceResponse
import io.github.eendroroy.sdk.portwallet.response.RetrieveInvoiceResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * @author indrajit
 */
class PWApiClient @JvmOverloads constructor(
    configuration: PWConfiguration,
    interceptor: PWInterceptor = DefaultPWInterceptor()
) {
    private val client: PWPaymentClient
    private val authProvider: PWAuthProvider

    init {
        authProvider = DefaultPWAuthProvider(configuration)
        val okHttpClientBuilder = if (configuration.acceptUnsafeSSL!!) {
            unsafeOkHttpClientBuilder
        } else {
            OkHttpClient.Builder()
        }
        val okHttpClient = okHttpClientBuilder.addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(configuration.baseUrl)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
        client = PWPaymentClient(retrofit, configuration, authProvider)
    }

    @Throws(Exception::class)
    fun createInvoice(request: InvoiceRequest): InvoiceResponse? {
        return client.createInvoice(request)
    }

    @Throws(Exception::class)
    fun ipnValidate(invoiceId: String, amount: Double): IpnValidateResponse? {
        return client.ipnValidate(invoiceId, amount)
    }

    @Throws(Exception::class)
    fun retrieveInvoice(invoiceId: String): RetrieveInvoiceResponse? {
        return client.retrieveInvoice(invoiceId)
    }

    @Throws(Exception::class)
    fun refundInvoice(request: RefundInvoiceRequest, invoiceId: String): RefundInvoiceResponse? {
        return client.refundInvoice(request, invoiceId)
    }
}
