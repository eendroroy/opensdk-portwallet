package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("emi")
data class EmiRequest(
    @JsonProperty("enable") var enable: Int? = null,
    @JsonProperty("tenure") var tenure: List<String>? = null,
)
