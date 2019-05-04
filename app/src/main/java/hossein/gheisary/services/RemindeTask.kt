package hossein.gheisary.services

import android.content.Context
import android.util.Log
import java.util.*
import kotlin.concurrent.schedule

class RemindeTask {
    companion object {
        var INCREMET_COUNT = "increment-count"

        fun executeTask(context:Context, action:String?){
            if(INCREMET_COUNT == action){
                Timer().schedule(4000){
                    increment(context)
                    Log.i("dfsdf", "incrementing .....")
                }
            }
        }

        private fun increment(context: Context) {
            PreferenceService(context).incrementCount()
        }
    }
}