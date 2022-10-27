package io.github.eendroroy.sdk.portwallet.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * @author indrajit
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class BaseResponse {
    var httpResponseCode: Int = 200
    var httpResponseMessage: String = "OK"
    abstract fun httpResponseCode(code: Int): BaseResponse
    abstract fun httpResponseMessage(message: String): BaseResponse
}
