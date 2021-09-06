package com.example.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutines.databinding.ActivityMainBinding
import com.example.coroutines.databinding.ActivitySplashBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val retornoAsync = CoroutineScope(Dispatchers.Main).async {
            waitSplashScreenTimer()
        }

        CoroutineScope(Dispatchers.Main).launch {

            val result = retornoAsync.await()

            if (result) {
                callNewActivity()
            }
        }
    }

    private suspend fun waitSplashScreenTimer(): Boolean {
        delay(3000)
        return true
    }

    private fun callNewActivity() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

}