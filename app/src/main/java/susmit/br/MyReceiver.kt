package susmit.br

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(context,"you fool " +
                "why you click me " +
                " if i told you to jump in well then will you jump", Toast.LENGTH_LONG).show()

    }
}
