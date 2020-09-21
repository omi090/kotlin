package com.omi.demograph.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class App(
    val currency: String,
    val `data`: Data,
    val money_format: String,
    val name: String
): Parcelable