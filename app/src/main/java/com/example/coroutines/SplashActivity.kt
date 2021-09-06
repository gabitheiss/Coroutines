package com.example.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutines.databinding.ActivityMainBinding
import com.example.coroutines.databinding.ActivitySplashBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashActivity : AppCompatActivity(), CoroutineScope {

    lateinit var binding: ActivitySplashBinding

    override val coroutineContext : CoroutineContext
    get() = Dispatchers.Main + Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val job = launch {
            toNextActivity()
        }
    }

    suspend fun toNextActivity(){
        val intent = Intent(this,MainActivity::class.java)
        delay(3000)
        withContext(Dispatchers.Main){
            startActivity(intent)
        }

    }
}