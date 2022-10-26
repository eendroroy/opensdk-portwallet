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
@JsonRootName("brand")
data class BrandResponse(
    @JsonProperty("name") var name: String? = null,
    @JsonProperty("type") var type: String? = null,
    @JsonProperty("category") var category: String? = null,
) : BaseResponse
