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
@JsonRootName("emi")
data class EmiResponse(
    @JsonProperty("partner") var partner: String? = null,
    @JsonProperty("tenor") var tenor: String? = null,
    @JsonProperty("is_used") var isUsed: Int? = null,
) : BaseResponse
