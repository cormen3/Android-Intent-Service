package hossein.gheisary.services

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hossein.gheisary.services.RemindeTask.Companion.INCREMET_COUNT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateReminderCount()

        btnPlus.setOnClickListener { increment() }
    }

    @SuppressLint("SetTextI18n")
    fun updateReminderCount(){
        val reminder = PreferenceService(applicationContext).getReminderCount()
        reminderTextView.text = "the reminder is: " + reminder
    }

    fun increment(){
        val intent = Intent(this, MyReminderIntentService::class.java)
        intent.action = INCREMET_COUNT
        startService(intent)

        updateReminderCount()
    }
}
