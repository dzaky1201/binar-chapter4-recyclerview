package com.dzakyhdr.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Username(
    val name: String? = null,
    val phone: String? = null
): Parcelable
