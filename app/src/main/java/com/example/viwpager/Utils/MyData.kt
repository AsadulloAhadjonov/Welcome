package com.example.viwpager.Utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.viwpager.Models.User
import com.example.viwpager.R

object MyData {
    val list = ArrayList<User>()
    @RequiresApi(Build.VERSION_CODES.O)
    fun addUser() {
        list.add(User(R.drawable.rectangle, "Xush kelibsiz", "Kim ko‘rubdur, ey ko‘ngul, ahli jahondin yaxshilig‘, \n" + "Kimki, ondin yaxshi yo‘q, ko‘z tutma ondin yaxshilig‘"))
        list.add(User(R.drawable.rectangle1, "Hikoyalar dunyosi", "Gar zamonni nayf qilsam ayb qilma, ey rafiq, \n" + "Ko‘rmadim hargiz, netoyin, bu zamondin yaxshilig‘ ! "))
        list.add(User(R.drawable.rectangle2, "Kitob ortidan..", "Dilrabolardin yomonliq keldi mahzun ko‘ngluma,\n" + " Kelmadi jonimg'a hech oromi jondin yaxshilig'."))
        list.add(User(R.drawable.rectangle3, "Bizga qo`shiling", "Ey ko‘ngul, chun yaxshidin ko‘rdung yamonliq asru ko‘p,\n" + " Emdi ko‘z tutmoq ne ma’ni har yamondin yaxshilig'?"))
    }
}