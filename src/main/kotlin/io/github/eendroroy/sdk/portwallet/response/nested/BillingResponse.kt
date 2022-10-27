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
@JsonRootName("billing")
data class BillingResponse(
    @JsonProperty("customer") var customer: CustomerResponse? = null,
    @JsonProperty("payer") var payer: PayerResponse? = null,
    @JsonProperty("gateway") var gateway: GatewayResponse? = null,
    @JsonProperty("source") var source: SourceResponse? = null,
) : BaseResponse() {
    override fun httpResponseCode(code: Int) = this.apply { this.httpResponseCode = code }
    override fun httpResponseMessage(message: String) = apply { this.httpResponseMessage = message }
}
