package com.example.todoapplicationbatch03.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tbl_todo")
data class ToDoModel(
    @PrimaryKey(autoGenerate = true)
    var todo_id:Long = 0,
    val user_id:Long = UUID.randomUUID().toString().toLong(),
    val name:String,
    val priority:String,
    var date:Long = System.currentTimeMillis(),
    var time:Long,
    var complete:Boolean = false
)
