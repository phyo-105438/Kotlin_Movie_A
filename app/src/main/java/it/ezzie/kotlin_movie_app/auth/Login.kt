package it.ezzie.kotlin_movie_app.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import it.ezzie.kotlin_movie_app.R
import it.ezzie.kotlin_movie_app.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBtnListener();

    }

    private fun initBtnListener() {
        binding.btnLogIn.setOnClickListener{
            val mail = binding.emailLayout.editText!!.text.toString()
            val password = binding.passwordLayout.editText!!.text.toString()
            if(TextUtils.isEmpty(mail) && TextUtils.isEmpty(password)){
                binding.emailLayout.error = "Please Enter Email"
                binding.emailLayout.requestFocus()
                binding.passwordLayout.error = "Please Enter Password"
                binding.passwordLayout.requestFocus()
            }
            else if(TextUtils.isEmpty(mail)){
                binding.emailLayout.error = "Please Enter Email"
                binding.emailLayout.requestFocus()
            }
            else if(TextUtils.isEmpty(password)){
                binding.passwordLayout.error = "Please Enter Password"
                binding.passwordLayout.requestFocus()
            }

            else{
                Toast.makeText(this, "Created Successfully", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCreate.setOnClickListener{
            var intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        binding.forgetPwdText.setOnClickListener{
            var intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)
        }
    }
}