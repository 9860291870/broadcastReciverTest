package susmit.br

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FilterReader

class MainActivity : AppCompatActivity() {
    lateinit var receiver: BroadcastReceiver
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context=this
        setContentView(R.layout.activity_main)


        var filter =IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        filter.addAction(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_HEADSET_PLUG)
        filter.addAction(Intent.ACTION_BATTERY_LOW)
        receiver=object:BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {

                Toast.makeText(context,intent?.action,Toast.LENGTH_LONG).show()
            }
        }
        registerReceiver(receiver,filter)
        b1.setOnClickListener({
            sendBroadcast(Intent(context,MyReceiver::class.java))
        })




    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}
