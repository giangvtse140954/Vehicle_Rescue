package giangvt.example.vehicle_rescue

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private var edtUsername: EditText? = null
    private var edtPwd: EditText? = null
    private var lb: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

    fun clickToLogin(view: View) {
        edtUsername = findViewById(R.id.edtUsername)
        edtPwd = findViewById(R.id.edtPwd)
        lb = findViewById(R.id.lb)

        if (edtUsername?.text.toString().equals("giangvt") && edtPwd?.text.toString().equals("123")) {
            lb?.text = ""
            val pref = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
            val editor = pref.edit()
            editor.putString("username", "giangvt")
            editor.putString("pwd", "123")
            editor.apply()

            val intent: Intent = Intent(this, MainActivity::class.java).apply {
                putExtra("status", true)
            }
            startActivity(intent)
            finish()
        } else {
            lb?.text = "Incorrect username or password"
        }

    }

}