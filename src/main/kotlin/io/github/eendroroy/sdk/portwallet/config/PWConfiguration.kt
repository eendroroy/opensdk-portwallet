package io.github.eendroroy.sdk.portwallet.config

/**
 * @author indrajit
 */
interface PWConfiguration {
    val baseUrl: String
    val appKey: String
    val appSecret: String
    val contentType: String
    val accept: String
    val redirectUrl: String
    val ipnUrl: String
    val acceptUnsafeSSL: Boolean?
}
