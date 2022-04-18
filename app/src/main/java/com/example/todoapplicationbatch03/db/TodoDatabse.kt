package com.example.todoapplicationbatch03.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapplicationbatch03.dao.ToDoDao
import com.example.todoapplicationbatch03.dao.UserDao
import com.example.todoapplicationbatch03.entity.ToDoModel
import com.example.todoapplicationbatch03.entity.UserModel

@Database(entities = [ToDoModel::class,UserModel::class], version = 1)
abstract class TodoDatabse:RoomDatabase() {
    abstract fun todoDao():ToDoDao
    abstract fun userDao():UserDao

    companion object{
        private var db:TodoDatabse? = null
        fun getDB(context: Context):TodoDatabse{
            if(db == null){
                db = Room.databaseBuilder(
                    context,
                    TodoDatabse::class.java,
                    "todo_db"
                ).build()
                return db!!
            }
            return db!!
        }
    }
}