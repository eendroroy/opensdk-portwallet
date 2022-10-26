package io.github.eendroroy.sdk.portwallet.response.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.portwallet.response.BaseResponse

/**
 * @author indrajit
 */
@JsonRootName("payer")
data class PayerResponse(
    @JsonProperty("name") var name: String? = null,
    @JsonProperty("account") var account: String? = null,
    @JsonProperty("ip_address") var ip_address: String? = null,
    @JsonProperty("user_agent") var user_agent: String? = null,
) : BaseResponse
