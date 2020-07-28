package com.android.jetpack.room

import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Flowable

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Insert
    fun inserUserList(users: Array<User>)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("select * from user")
    fun selectAll(): Array<User>

    @Query("select * from user where name=:name")
    fun selectUser(name: String): Array<User>

    @Query("select name,city from user")
    fun loadUserCity(): List<UserTuple>

    @Query("select name,street from user where city in (:cityArray)")
    fun loadUserInCity(cityArray: Array<String>): List<UserTuple>

    @Query("select name,street from user where city in (:cityArray)")
    fun loadUserInCityLive(cityArray: Array<String>): LiveData<Array<UserTuple>>

    @Query("select * from user where id =:id LIMIT 1")
    fun loadUserRxJava(id: Int): Flowable<User>

}