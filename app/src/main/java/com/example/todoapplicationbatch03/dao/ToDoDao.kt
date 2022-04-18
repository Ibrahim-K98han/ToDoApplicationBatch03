package com.example.todoapplicationbatch03.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoapplicationbatch03.entity.ToDoModel

@Dao
interface ToDoDao {

    @Insert
    suspend fun insertTodo(toDoModel: ToDoModel)

    @Update
    suspend fun updateToDo(toDoModel: ToDoModel)

    @Delete
   suspend fun deleteToDo(toDoModel: ToDoModel)

    @Query("select * from tbl_todo where user_id = :userId")
    fun getToDoByUserId(userId:Long):LiveData<List<ToDoModel>>

}