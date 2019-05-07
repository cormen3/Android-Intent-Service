package hossein.gheisary.services.intentService

import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*
import kotlin.concurrent.schedule
import android.os.Messenger
import android.os.Message
import android.os.RemoteException
import hossein.gheisary.services.intentService.updateUiWithHandler.PreferenceService


class RemindeTask {
    companion object {
        var INCREMET_COUNT = "increment-count"

        fun executeTask(context:Context, intent:Intent){


            for (i in 1..1000000){
                Log.i("" , "i is " + i)
            }


            val bundle = intent?.extras

            var action = intent.action
            if(INCREMET_COUNT == action){
                Timer().schedule(4000){
                    increment(context)

                    if (bundle != null) {
                        val messenger = bundle.get("messenger") as Messenger
                        bundle.putInt("myData", PreferenceService(
                            context
                        ).getReminderCount())
                        val msg = Message.obtain()
                        msg.data = bundle //put the data here
                        try {
                            messenger.send(msg)
                        } catch (e: RemoteException) {
                            Log.i("error", "error")
                        }

                    }
                }
            }
        }

        private fun increment(context: Context) {
            PreferenceService(context).incrementCount()
        }
    }
}