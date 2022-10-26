package io.github.eendroroy.sdk.portwallet.config

/**
 * @author indrajit
 */
abstract class AbstractPWConfiguration : PWConfiguration {
    abstract override val baseUrl: String
    abstract override val appKey: String
    abstract override val appSecret: String
    abstract override val contentType: String
    abstract override val accept: String
    abstract override val redirectUrl: String
    abstract override val ipnUrl: String
    override val acceptUnsafeSSL = false
}
