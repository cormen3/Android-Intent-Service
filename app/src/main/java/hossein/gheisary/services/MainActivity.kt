package hossein.gheisary.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hossein.gheisary.services.intentService.updateUiWithHandler.IntentServiceActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent.setOnClickListener { startActivity(Intent(this@MainActivity, IntentServiceActivity::class.java)) }
    }

}
