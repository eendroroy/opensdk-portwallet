package io.github.eendroroy.sdk.portwallet.util

import java.util.concurrent.TimeUnit

// val currentMillis: Long get() = System.currentTimeMillis()
val currentSeconds: Long get() = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())
// val currentMinutes: Long get() = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis())
// val currentHours: Long get() = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis())
// val currentDays: Long get() = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis())
