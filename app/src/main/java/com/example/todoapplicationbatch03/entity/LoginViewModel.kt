package com.example.todoapplicationbatch03.entity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.todoapplicationbatch03.dao.UserDao
import com.example.todoapplicationbatch03.db.TodoDatabse
import kotlinx.coroutines.launch

class LoginViewModel(application:Application)
    :AndroidViewModel(application) {
        private var userDao:UserDao = TodoDatabse.getDB(application).userDao()

    val errMsgLD:MutableLiveData<String> = MutableLiveData()
    var userModel:UserModel? = null

    fun login(email:String,password:String,callback:(Long)->Unit){
        viewModelScope.launch {
            userModel = userDao.getUserByEmail(email)
            if(userModel !=null){
                if(password == userModel!!.password){
                    callback(userModel!!.user_id)
                }else{
                    errMsgLD.value = "Incorrect password"
                }
            }else{
                errMsgLD.value = "Email does not exist"
            }
        }
    }
    fun register(user: UserModel,callback: (Long) -> Unit){
        viewModelScope.launch {
            userModel = userDao.getUserByEmail(user.email)
            if (userModel !=null){
                errMsgLD.value = "Email already exist!!"
            }else{
                val id = userDao.insertUser(user)
                user.user_id = id
                userModel = user
                callback(id)
            }

        }
    }
}