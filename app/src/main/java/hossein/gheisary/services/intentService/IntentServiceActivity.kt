package hossein.gheisary.services.intentService.updateUiWithHandler

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.Messenger
import hossein.gheisary.services.R
import hossein.gheisary.services.intentService.RemindeTask.Companion.INCREMET_COUNT
import kotlinx.android.synthetic.main.activity_intent_service.*

class IntentServiceActivity : AppCompatActivity() {

    lateinit var handler:Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)

        updateReminderCount()

        btnPlus.setOnClickListener { increment() }

        handler  = @SuppressLint("HandlerLeak")
        object : Handler() {
            override fun handleMessage(msg: Message) {
                val reply = msg.data
                var count = reply.getInt("myData")
                reminderTextView.text = "the reminder is: " + count
            }
        }

        var handler2 = Handler(Handler.Callback { msg ->
            true
        })

        var test = Handler()

    }

    @SuppressLint("SetTextI18n")
    fun updateReminderCount(){
        val reminder = PreferenceService(applicationContext)
            .getReminderCount()
        reminderTextView.text = "the reminder is: " + reminder
    }

    fun increment(){
        val intent = Intent(this, MyReminderIntentService::class.java)
        intent.action = INCREMET_COUNT
        intent.putExtra("messenger", Messenger(handler))
        startService(intent)
    }
}
