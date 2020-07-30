package com.example.android.jetpack_demo.bean

//{
//    "data": {
//    "admin": false,
//    "chapterTops": [],
//    "coinCount": 0,
//    "collectIds": [],
//    "email": "",
//    "icon": "",
//    "id": 72209,
//    "nickname": "hello1234567",
//    "password": "",
//    "publicName": "hello1234567",
//    "token": "",
//    "type": 0,
//    "username": "hello1234567"
//},
//    "errorCode": 0,
//    "errorMsg": ""
//}


data class LoginBean(
    var data: Data? = null,
    var errorCode: Int = 0,
    var errorMsg: String? = null
) {



    data class Data(
        var chapterTops: List<*>? = null, var collectIds: List<Int>? = null,
        var email: String? = null,
        var icon: String? = null,
        var id: Int = 0,
        var password: String? = null,
        var token: String? = null,
        var type: Int = 0,
        var username: String? = null
    )
}