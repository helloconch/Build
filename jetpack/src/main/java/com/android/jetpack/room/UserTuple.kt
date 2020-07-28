package com.android.jetpack.room

import androidx.room.ColumnInfo

class UserTuple {
    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "city")
    var city: String? = null

    @ColumnInfo(name = "street")
    var street: String? = null

    override fun toString(): String {
        return "UserTuple(name=$name, city=$city, street=$street)"
    }


}