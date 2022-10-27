package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("emi")
data class EmiRequest(
    @field:JsonProperty("enable") var enable: Int? = null,
    @field:JsonProperty("tenures") var tenures: List<Int>? = null,
)
