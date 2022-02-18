package com.algospace
import com.algospace.data_structures.*
import java.util.*
import kotlin.math.*
import kotlin.collections.mutableListOf
import java.io.PrintWriter
import java.util.StringTokenizer
fun code(){
    var a=Tensor<Int>(16)
    for(i in 0..15)a[i]=i
    for(i in a)print("$i ")
}
fun main(){
    code()
}
class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}
private fun readLn()=readLine()!!
private fun readInt()=readLn().toInt()
private fun readLong()=readLn().toLong()
private fun readDouble()=readLn().toDouble()
private fun readStrings()=readLn().split(" ")
private fun readInts()=readStrings().map{it.toInt()}
private fun readLongs()=readStrings().map{it.toLong()}
private fun readDoubles()=readStrings().map{it.toDouble()}
