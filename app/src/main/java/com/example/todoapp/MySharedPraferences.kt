package com.example.todoapp

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPraferences {
    private const val NAME = "KeshXotirjyfjaga"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var obektString: ArrayList<ToDoPlan>
        get() = gsonStringToArray(preferences.getString("obekt", "[]")!!)
        set(value) = preferences.edit {
            it.putString("obekt", arrayToGsonString(value))
        }

    fun arrayToGsonString(arrayList: ArrayList<ToDoPlan>): String {
        return Gson().toJson(arrayList)
    }

    fun gsonStringToArray(gsonString: String): ArrayList<ToDoPlan> {
        val typeToken = object : TypeToken<ArrayList<ToDoPlan>>() {}.type
        return Gson().fromJson(gsonString, typeToken)
    }
}