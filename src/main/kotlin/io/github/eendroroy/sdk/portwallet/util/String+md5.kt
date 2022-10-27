package io.github.eendroroy.sdk.portwallet.util

import java.security.MessageDigest
import java.util.Locale

internal fun String.md5(): String = MessageDigest.getInstance("MD5").let {
    it.update(this.toByteArray())
    it.digest().toHex().lowercase(Locale.getDefault())
}

internal fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }
