package io.github.eendroroy.sdk.portwallet.converter

import io.github.eendroroy.sdk.portwallet.response.BaseResponse
import retrofit2.Response
import retrofit2.Retrofit

/**
 * @author indrajit
 */
internal class ResponseConverter<T>(var retrofit: Retrofit, var apiResponse: Response<T>) {
    inline fun <reified T> convert(): T? {
        val response: T? = when {
            apiResponse.isSuccessful -> {
                apiResponse.body() as T?
            }
            null == apiResponse.errorBody() -> {
                throw Exception("${apiResponse.code()} : ${apiResponse.message()}")
            }
            0L == apiResponse.errorBody()!!.contentLength() -> {
                throw Exception("${apiResponse.code()} : ${apiResponse.message()}")
            }
            else -> {
                val errorConverter = retrofit.responseBodyConverter<T>(T::class.java, arrayOfNulls(0))
                errorConverter.convert(apiResponse.errorBody()!!)
            }
        }

        if (response is BaseResponse) {
            response.httpResponseCode(apiResponse.code()).httpResponseMessage(apiResponse.message())
        }

        return response
    }
}
