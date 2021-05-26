package giangvt.example.vehicle_rescue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var btnClick: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick = findViewById(R.id.btnClick)
        btnClick?.setOnClickListener(View.OnClickListener { view ->
            when(view.id) {
                R.id.btnClick -> {
                    val intent: Intent = Intent(this, LoginActivity::class.java).apply {
                        putExtra("status", false)
                    }

                    val pref = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
                    val editor = pref.edit()
                    editor.putString("username", null)
                    editor.putString("pwd", null)
                    editor.apply()

                    startActivity(intent)
                    finish()
                }
            }
        })
    }
}