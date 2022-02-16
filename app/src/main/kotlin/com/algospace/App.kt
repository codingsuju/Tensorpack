package com.algospace
import com.algospace.data_structures.*
import java.util.*
import kotlin.math.*
import kotlin.collections.mutableListOf
import java.io.PrintWriter
import java.util.StringTokenizer
fun code(){
    var tensor=tensorOf(tensorOf(2,3),tensorOf(2,4),tensorOf(2,1),tensorOf(2,5))
    tensor.sort({a:Tensor<Int>,b:Tensor<Int> ->
        b.compareTo(a)
    })
    printTensorOfTensor(tensor)
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
