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
@JsonRootName("gateway")
data class GatewayResponse(
    @JsonProperty("category") var category: String? = null,
    @JsonProperty("network") var network: String? = null,
    @JsonProperty("status") var status: String? = null,
    @JsonProperty("transaction_id") var transaction_id: String? = null,
    @JsonProperty("approve_code") var approveCode: String? = null,
    @JsonProperty("reason") var reason: String? = null,
) : BaseResponse() {
    override fun httpResponseCode(code: Int) = this.apply { this.httpResponseCode = code }
    override fun httpResponseMessage(message: String) = apply { this.httpResponseMessage = message }
}
