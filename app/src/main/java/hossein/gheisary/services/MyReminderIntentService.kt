package hossein.gheisary.services

import android.app.IntentService
import android.content.Intent

class MyReminderIntentService:IntentService("MyReminderIntentService") {
    override fun onHandleIntent(intent: Intent?) {
        var action = intent?.action
        RemindeTask.executeTask(this, action)
    }
}