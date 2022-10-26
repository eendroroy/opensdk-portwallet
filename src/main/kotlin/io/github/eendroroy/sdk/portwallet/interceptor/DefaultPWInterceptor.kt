package io.github.eendroroy.sdk.portwallet.interceptor

import okhttp3.Request
import okhttp3.Response

/**
 * @author indrajit
 */
class DefaultPWInterceptor : AbstractPWInterceptor() {
    override fun interceptRequest(request: Request): Request {
        return request
    }

    override fun interceptResponse(response: Response): Response {
        return response
    }
}
