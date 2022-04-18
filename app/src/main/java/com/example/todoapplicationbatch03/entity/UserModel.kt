package com.example.todoapplicationbatch03.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var user_id:Long = 0,
    var email:String,
    var password:String
)
