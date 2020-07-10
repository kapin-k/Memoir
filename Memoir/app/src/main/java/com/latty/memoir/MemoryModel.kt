package com.latty.memoir

import java.util.*

data class MemoryModel(
    val date: Date?, // Image date Calendar.Date Format
    val header: String?,
    val picture: Int, // R.drawable.* -> Image resource ID
    val caption: String
)