package com.android.jetpack.room

import androidx.room.ColumnInfo

class Address {
    var street: String? = null
    var state: String? = null
    var city: String? = null
    @ColumnInfo(name = "post_code")
    var postCode = 0
}