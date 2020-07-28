package com.android.jetpack.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    var strength = 0

    var name: String? = null

    @Embedded
    var address: Address? = null


}