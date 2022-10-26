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
@JsonRootName("error")
data class ErrorResponse(
    @JsonProperty("cause") var result: String? = null,
    @JsonProperty("explanation") var explanation: String? = null,
    @JsonProperty("property") var property: String? = null,
) : BaseResponse