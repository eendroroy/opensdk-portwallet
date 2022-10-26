package io.github.eendroroy.sdk.portwallet.config

import io.github.eendroroy.sdk.portwallet.util.md5
import org.joda.time.DateTime
import java.util.Base64

/**
 * @author indrajit
 */
class DefaultPWAuthProvider(private val configuration: PWConfiguration) : PWAuthProvider {
    override val authorization: String
        get() {
            val timestamp = DateTime.now().millis / 1_000
            val secretString = (configuration.appSecret + timestamp).md5()
            val encodedString =
                Base64.getEncoder().encodeToString((configuration.appKey + ":" + secretString).toByteArray())
            return "Bearer $encodedString"
        }
}
