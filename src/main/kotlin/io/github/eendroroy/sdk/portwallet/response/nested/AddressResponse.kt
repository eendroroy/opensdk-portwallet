package io.github.eendroroy.sdk.portwallet.response.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.response.BaseResponse

/**
 * @author indrajit
 */
@JsonRootName("address")
data class AddressResponse(
    @JsonProperty("street") var street: Any? = null,
    @JsonProperty("city") var city: Any? = null,
    @JsonProperty("state") var state: Any? = null,
    @JsonProperty("zipcode") var zipcode: Any? = null,
    @JsonProperty("country") var country: String? = null,
) : BaseResponse() {
    override fun httpResponseCode(code: Int) = this.apply { this.httpResponseCode = code }
    override fun httpResponseMessage(message: String) = apply { this.httpResponseMessage = message }
}
