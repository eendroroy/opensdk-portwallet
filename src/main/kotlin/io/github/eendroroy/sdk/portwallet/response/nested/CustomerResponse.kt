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
@JsonRootName("customer")
data class CustomerResponse(
    @JsonProperty("name") var name: String? = null,
    @JsonProperty("email") var email: String? = null,
    @JsonProperty("phone") var phone: String? = null,
    @JsonProperty("address") var address: AddressResponse? = null,
) : BaseResponse() {
    override fun httpResponseCode(code: Int) = this.apply { this.httpResponseCode = code }
    override fun httpResponseMessage(message: String) = apply { this.httpResponseMessage = message }
}
