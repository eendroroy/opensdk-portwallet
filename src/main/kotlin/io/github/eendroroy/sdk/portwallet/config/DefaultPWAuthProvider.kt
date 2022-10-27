package io.github.eendroroy.sdk.portwallet.config

import io.github.eendroroy.sdk.portwallet.util.currentSeconds
import io.github.eendroroy.sdk.portwallet.util.md5
import java.util.Base64

/**
 * @author indrajit
 */
class DefaultPWAuthProvider(private val configuration: PWConfiguration) : PWAuthProvider {
    override val authorization: String
        get() {
            val secretString = (configuration.appSecret + currentSeconds).md5()
            val encodedString =
                Base64.getEncoder().encodeToString(("${configuration.appKey}:$secretString").toByteArray())
            return "Bearer $encodedString"
        }
}
