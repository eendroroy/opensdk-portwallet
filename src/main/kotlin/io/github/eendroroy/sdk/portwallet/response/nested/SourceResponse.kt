package io.github.eendroroy.sdk.portwallet.response.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.response.BaseResponse

/**
 * @author indrajit
 */
@JsonRootName("source")
data class SourceResponse(
    @JsonProperty("category") var category: String? = null,
    @JsonProperty("number") var number: String? = null,
    @JsonProperty("brand") var brand: BrandResponse? = null,
    @JsonProperty("issuer") var issuer: IssuerResponse? = null,
) : BaseResponse() {
    override fun httpResponseCode(code: Int) = this.apply { this.httpResponseCode = code }
    override fun httpResponseMessage(message: String) = apply { this.httpResponseMessage = message }
}
