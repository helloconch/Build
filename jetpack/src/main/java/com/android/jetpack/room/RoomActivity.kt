package com.android.jetpack.room

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.android.jetpack.R
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.layout_room.*

class RoomActivity : AppCompatActivity() {

    private val userDao: UserDao by lazy {
        roomTestData.userDao()
    }

    private var liveData: LiveData<Array<UserTuple>> = MutableLiveData()
        get() {
            return userDao.loadUserInCityLive(arrayOf("B"))
        }

    private val stringName = "Name"
    private var number = 0
    private val fragmentManger: FragmentManager by lazy {
        supportFragmentManager
    }

    val builder: StringBuilder by lazy {
        StringBuilder()
    }

    private val roomTestData: RoomTestData by lazy {
        RoomTestData.getInstance(this)
    }


    val handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            tv_main_show.text = msg?.obj as String
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_room)
        btnAdd.setOnClickListener { addUser() }
        btnQuery.setOnClickListener { query() }
        btnUpdate.setOnClickListener { update() }
        btnDelete.setOnClickListener { delete() }

        val observer = Observer<Array<UserTuple>> {
            val stringBuilder = StringBuilder()
            for (index in it!!.indices) {
                val userTuple = it[index]
                stringBuilder.append(userTuple.name)
                    .append("   ")
                    .append(userTuple.street)
                    .append("   \n")
            }
            Log.i("AABBCCDD", ">>> " + stringBuilder.toString());
            tv_main_show.text = stringBuilder.toString()
        }
        liveData?.observe(this, observer)
    }

    private fun addUser() {
        Thread(Runnable {
            val user = User()
            user.name = "罗平安 编号 = $number"
            user.strength = 100
            val address = Address()
            address.street = "成都"
            address.state = "蜀汉"
            address.city = "B"
            address.postCode = 10010 + number++
            user.address = address
            userDao.insertUser(user)
        }).start()
    }

    private fun update() {
        Thread(Runnable {
            val user = User()
            user.id = 4
            user.strength = 100
            userDao.updateUser(user)
        }).start()
    }

    private fun delete() {
        Thread(Runnable {
            val user = User()
            user.id = 1
            userDao.deleteUser(user)
        }).start()
    }

    private fun query() {
        val stringBuilder = StringBuilder()
        Thread(Runnable {
            val userList = userDao.selectAll()

            for (user in userList) {
                stringBuilder.append(user.id)
                    .append("   ")
                    .append(user.name)
                    .append("   ")
                    .append(user.strength)
                    .append("   \n")
                    .append(user.address?.state)
                    .append("   ")
                    .append(user.address?.city)
                    .append("   ")
                    .append(user.address?.street)
                    .append("   ")
                    .append(user.address?.postCode)
                    .append("\n")
            }
            val message = Message.obtain(handler)
            message.obj = stringBuilder.toString()
            handler.sendMessage(message)
        }).start()
    }

    private fun queryUserAndCity() {

        Thread(Runnable {
            liveData = userDao.loadUserInCityLive(arrayOf("常山"))
        }).start()
    }

    private fun queyRxJava() {
        userDao.loadUserRxJava(4)
            .subscribe(Consumer {
                val stringBuilder = StringBuilder()
                stringBuilder.append(it.id)
                    .append("   ")
                    .append(it.name)
                    .append("   ")
                    .append(it.strength)
                    .append("   \n")
                tv_main_show.text = stringBuilder.toString()
            })
    }
}