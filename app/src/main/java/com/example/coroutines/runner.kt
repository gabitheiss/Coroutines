package com.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>){
    runBlocking {
        runFor()
    }
    println("Ok")
}

suspend fun runFor(){
    for (i in 0..10){
        delay(1000)
        println("Posição $i")
    }
}