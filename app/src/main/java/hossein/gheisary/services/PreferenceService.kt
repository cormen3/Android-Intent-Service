package hossein.gheisary.services

import android.content.Context
import android.content.SharedPreferences

class PreferenceService constructor(var context: Context) {
    private val KEY_USERNAME = "USER_NAME"
    private val KEY_REMINDER_COUNT = "KEY_REMINDER_COUNT"
    private val KEY_PRRFERENCE_NAME = "ir.cobal.data"

    companion object {
        private var sharedPreferences: SharedPreferences? = null
    }

    init {
        if (sharedPreferences == null) {
            sharedPreferences = context.applicationContext.getSharedPreferences(KEY_PRRFERENCE_NAME, Context.MODE_PRIVATE)
        }
    }

    fun clearPreferences() {
        sharedPreferences!!.edit().clear().apply()
    }

    fun setUserName(userName: String) {
        val editor = sharedPreferences!!.edit()
        editor.putString(KEY_USERNAME, userName)
        editor.apply()
    }

    fun clearUserName() {
        val editor = sharedPreferences!!.edit()
        editor.remove(KEY_USERNAME)
        editor.apply()
    }

    fun getReminderCount(): Int {
        return sharedPreferences!!.getInt(KEY_REMINDER_COUNT, 0)
    }

    fun setReminderCount(counter: Int) {
        val editor = sharedPreferences!!.edit()
        editor.putInt(KEY_REMINDER_COUNT, counter)
        editor.apply()
    }

    fun incrementCount() {

        var counter = getReminderCount()
        counter++
        setReminderCount(counter)
    }


}