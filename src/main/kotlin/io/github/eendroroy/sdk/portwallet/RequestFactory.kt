package io.github.eendroroy.sdk.portwallet

import io.github.eendroroy.sdk.portwallet.config.PWConfiguration
import io.github.eendroroy.sdk.portwallet.request.InvoiceRequest
import io.github.eendroroy.sdk.portwallet.request.SimpleInvoiceRequest
import io.github.eendroroy.sdk.portwallet.request.nested.AddressRequest
import io.github.eendroroy.sdk.portwallet.request.nested.BillingRequest
import io.github.eendroroy.sdk.portwallet.request.nested.CustomerRequest
import io.github.eendroroy.sdk.portwallet.request.nested.OrderRequest
import io.github.eendroroy.sdk.portwallet.request.nested.ProductRequest
import io.github.eendroroy.sdk.portwallet.request.nested.ShippingRequest

/**
 * @author indrajit
 */
class RequestFactory private constructor() {
    private var configuration: PWConfiguration? = null
    private fun withConfiguration(configuration: PWConfiguration): RequestFactory {
        this.configuration = configuration
        return this
    }

    fun invoiceRequest(simpleRequest: SimpleInvoiceRequest): InvoiceRequest {
        return InvoiceRequest(
            order = getOrder(simpleRequest),
            product = ProductRequest(),
            billing = getBilling(simpleRequest),
            shipping = getShipping(simpleRequest),
        )
    }

    private fun getOrder(simpleRequest: SimpleInvoiceRequest): OrderRequest {
        return OrderRequest(
            amount = simpleRequest.amount,
            currency = simpleRequest.currency,
            reference = simpleRequest.reference,
            redirectUrl = configuration!!.redirectUrl,
            ipnUrl = configuration!!.ipnUrl,
        )
    }

    private fun getBilling(simpleRequest: SimpleInvoiceRequest): BillingRequest {
        return BillingRequest(customer = getCustomer(simpleRequest))
    }

    private fun getShipping(simpleRequest: SimpleInvoiceRequest): ShippingRequest {
        return ShippingRequest(customer = getCustomer(simpleRequest))
    }

    private fun getCustomer(simpleRequest: SimpleInvoiceRequest): CustomerRequest {
        return CustomerRequest(
            name = simpleRequest.customerName,
            phone = simpleRequest.customerPhone,
            email = simpleRequest.customerEmail,
            address = AddressRequest(),
        )
    }

    companion object {
        private val INSTANCE = RequestFactory()
        fun getInstance(configuration: PWConfiguration): RequestFactory {
            return INSTANCE.withConfiguration(configuration)
        }
    }
}
