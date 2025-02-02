package it.ezzie.kotlin_movie_app.auth

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import it.ezzie.kotlin_movie_app.R
import it.ezzie.kotlin_movie_app.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEditText();
    }
    private fun initEditText(){
        binding.btnSignUp.setOnClickListener{
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
                registerAccount(mail,password);
            }
        }
    }
    private fun registerAccount(mail : String , password : String){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show()
                finish()
                onBackPressed()
            }
            else{
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}