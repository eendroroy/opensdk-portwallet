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
@JsonRootName("action")
data class ActionResponse(
    @JsonProperty("type") var type: String? = null,
    @JsonProperty("url") var url: String? = null,
    @JsonProperty("payload") var payload: Any? = null,
    @JsonProperty("method") var method: String? = null,
) : BaseResponse
