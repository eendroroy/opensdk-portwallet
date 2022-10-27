package io.github.eendroroy.sdk.portwallet.util

import java.util.concurrent.TimeUnit

// internal val currentMillis: Long get() = System.currentTimeMillis()
internal val currentSeconds: Long get() = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())
// internal al currentMinutes: Long get() = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis())
// internal al currentHours: Long get() = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis())
// internal al currentDays: Long get() = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis())
