package com.example.coroutines


import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import com.example.coroutines.databinding.ActivityMainBinding
import com.example.coroutines.databinding.FragmentMainBinding
import kotlinx.coroutines.*


class MainFragment : Fragment(R.layout.fragment_main) {


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        val retornoAsync = CoroutineScope(Dispatchers.Main).async {
             percorrerNames()
        }

        CoroutineScope(Dispatchers.Main).launch {
            val retorno = retornoAsync.await()
            binding.textViewNames.text = retorno
        }

    }


    private suspend fun percorrerNames() : String {
        val names = listOf("Gabriela" , "Edson", "Danilo" , "Tatiane", "Felipe", "Matheus")
        names.forEach {
            binding.textViewNames.text = it
            delay(1000)
        }
        return "Percorremos ${names.size} nomes"
    }

}