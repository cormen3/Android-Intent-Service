package hossein.gheisary.services.intentService.updateUiWithHandler

import android.app.IntentService
import android.content.Intent
import hossein.gheisary.services.intentService.RemindeTask

class MyReminderIntentService:IntentService("MyReminderIntentService") {
    override fun onHandleIntent(intent: Intent?) {
        RemindeTask.executeTask(this, intent!!)
    }
}