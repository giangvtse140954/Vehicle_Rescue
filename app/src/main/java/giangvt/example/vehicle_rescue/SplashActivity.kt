package giangvt.example.vehicle_rescue

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pref = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
        val username = pref.getString("username", null)
        val pwd = pref.getString("pwd", null)
        print("username: $username, password: $pwd")
        if (username != null || pwd != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}