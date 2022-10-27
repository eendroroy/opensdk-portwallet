package io.github.eendroroy.sdk.portwallet.client

import io.github.eendroroy.sdk.portwallet.request.InvoiceRequest
import io.github.eendroroy.sdk.portwallet.request.RefundInvoiceRequest
import io.github.eendroroy.sdk.portwallet.response.InvoiceResponse
import io.github.eendroroy.sdk.portwallet.response.IpnValidateResponse
import io.github.eendroroy.sdk.portwallet.response.RefundInvoiceResponse
import io.github.eendroroy.sdk.portwallet.response.RetrieveInvoiceResponse

/**
 * @author indrajit
 */
interface PWClient {
    fun createInvoice(request: InvoiceRequest): InvoiceResponse?
    fun ipnValidate(invoiceId: String, amount: Double): IpnValidateResponse?
    fun retrieveInvoice(invoiceId: String?): RetrieveInvoiceResponse?
    fun refundInvoice(request: RefundInvoiceRequest, invoiceId: String): RefundInvoiceResponse?
}
