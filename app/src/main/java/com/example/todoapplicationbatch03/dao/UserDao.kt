package com.example.todoapplicationbatch03.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoapplicationbatch03.entity.UserModel

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(userModel: UserModel):Long

    @Insert
    suspend fun deleteUser(userModel: UserModel)

    @Insert
    suspend fun updateUser(userModel: UserModel)

    @Query("select * from tbl_user where email = :email")
    suspend fun getUserByEmail(email:String):UserModel?

}