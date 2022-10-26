package io.github.eendroroy.sdk.portwallet.request.nested

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("discount")
data class DiscountRequest(
    @JsonProperty("enable") var enable: Int? = null,
    @JsonProperty("codes") var codes: List<String>? = null,
)
