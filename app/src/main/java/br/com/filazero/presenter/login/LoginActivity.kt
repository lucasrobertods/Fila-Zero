package br.com.filazero.presenter.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.filazero.R
import br.com.filazero.databinding.ActivityLoginBinding
import br.com.filazero.presenter.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        binding.btnEntrar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}