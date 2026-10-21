package com.example.nadjmi_3tic

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nadjmi_3tic.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogin.setOnClickListener {
            val user = binding.edtUsername.text.toString().trim()
            val pass = binding.edtPassword.text.toString().trim()

            // Simple validation check: non-empty username & password
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save login state in SharedPreferences
            val sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE)
            sharedPref.edit().apply {
                putBoolean("isLogin", true)
                putString("username", user)
                apply()
            }

            Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LoginActivity, MainActivity::class.java).apply {
                putExtra("nama", "Nadjmi Fitria Mumpuni")
            }
            startActivity(intent)
            finish()
        }
    }
}
