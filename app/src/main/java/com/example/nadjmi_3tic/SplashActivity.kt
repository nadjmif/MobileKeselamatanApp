package com.example.nadjmi_3tic

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nadjmi_3tic.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            if (isLogin) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 1500)
    }
}
