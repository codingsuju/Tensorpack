package com.algospace.data_structures
import kotlin.math.*
import kotlin.collections.*
import java.util.*
fun <T:Comparable<T>> Tensor<T>.sort(lambda:((T,T)->Int)?=null){
    var m=this.size()
    var vector:Vector<T> =Vector(m)
    vector.setSize(m)
    for(i in 0..(m-1)){
        vector[i]=this[i]
    }
    if(lambda==null){
       vector.sort()
    }
    else{
        vector.sortWith(lambda)
    }
    for(i in 0..(m-1)){
        this.a[i]=vector[i]
    }
}
fun <T:Comparable<T>> printTensor(tensor:Tensor<T>){
    for(i in 0..(tensor.size()-1))print("${tensor[i]} ")
    println()
}
fun <T:Comparable<T>> printTensorOfTensor(tensor:Tensor<Tensor<T>>){
    for(i in 0..(tensor.size()-1)){
        for(j in 0..(tensor[i].size()-1)){
            print("${tensor[i][j]} ")
        }
        println()
    }
}

fun <T:Comparable<T>> tensorOf(vararg t:T):Tensor<T>{
    var m=t.size
    var tensor=Tensor<T>(m,null)
    for(i in 0..(m-1))tensor[i]=t[i]
    return tensor
}
fun <T:Comparable<T>> Tensor<T>.min():T{
    if(this.size()==0){
        if(this.defaultValue==null){
            println("Empty Tensor, and defaultValue is null")
        }
        else return defaultValue!!
    }
    var ans=this[0]
    for(i in 1..(this.size()-1)){
        if(this[i].compareTo(ans)==-1)ans=this[i]
    }
    return ans
}
fun <T:Comparable<T>> Tensor<T>.max():T{
    if(this.size()==0){
        if(this.defaultValue==null){
            println("Empty Tensor, and defaultValue is null")
        }
        else return defaultValue!!
    }
    var ans=this[0]
    for(i in 1..(this.size()-1)){
        if(this[i].compareTo(ans)==1)ans=this[i]
    }
    return ans
}
fun Tensor<Int>.sum(i:Int,j:Int,f:LongArray):Long{
    return f[j+1]-f[i]
}
fun Tensor<Int>.prefixSum():LongArray{
    var n:Int=this.size()
    var f:LongArray =LongArray(n+1){0L}
    for(i in 0..(n-1))f[i+1]=this[i].toLong()+f[i]
    return f
}
@JvmName("ListToTensor")
fun <T:Comparable<T>> List<T>.toTensor():Tensor<T>{
    var m=this.size
    var tensor=Tensor<T>(m,null)
    for(i in 0..(m-1))tensor[i]=this[i]
    return tensor
}
@JvmName("MutableListToTensor")
fun <T:Comparable<T>> MutableList<T>.toTensor():Tensor<T>{
    var m=this.size
    var tensor=Tensor<T>(m,null)
    for(i in 0..(m-1))tensor[i]=this[i]
    return tensor
}
@JvmName("ArrayToTensor")
fun <T:Comparable<T>> Array<T>.toTensor():Tensor<T>{
    var m=this.size
    var tensor=Tensor<T>(m,null)
    for(i in 0..(m-1))tensor[i]=this[i]
    return tensor
} 
@JvmName("IntArrayToTensor")
fun IntArray.toTensor():Tensor<Int>{
    var m=this.size
    var tensor=Tensor<Int>(m,null)
    for(i in 0..(m-1))tensor[i]=this[i]
    return tensor
}
@JvmName("LongArrayToTensor")
fun LongArray.toTensor():Tensor<Long>{
    var m=this.size
    var tensor=Tensor<Long>(m,null)
    for(i in 0..(m-1))tensor[i]=this[i]
    return tensor
} 
@JvmName("ListOfListToTensor")
fun <T:Comparable<T>> getTensorOfTensor(list:List<List<T>>):Tensor<Tensor<T>>{
    var m=list.size
    var n=list[0].size
    var tensor=Tensor<Tensor<T>>(m,null)
    for(i in 0..(m-1)){
        var e=Tensor<T>(n,null)
        for(j in 0..(n-1)){
            e[j]=list[i][j]
        }
        tensor[i]=e
    }
    return tensor
}
@JvmName("MutableListOfListToTensor")
fun <T:Comparable<T>> getTensorOfTensor(list:MutableList<List<T>>):Tensor<Tensor<T>>{
    var m=list.size
    var n=list[0].size
    var tensor=Tensor<Tensor<T>>(m,null)
    for(i in 0..(m-1)){
        var e=Tensor<T>(n,null)
        for(j in 0..(n-1)){
            e[j]=list[i][j]
        }
        tensor[i]=e
    }
    return tensor
}
@JvmName("MutableListOfMutableListToTensor")
fun <T:Comparable<T>> getTensorOfTensor(list:MutableList<MutableList<T>>):Tensor<Tensor<T>>{
    var m=list.size
    var n=list[0].size
    var tensor=Tensor<Tensor<T>>(m,null)
    for(i in 0..(m-1)){
        var e=Tensor<T>(n,null)
        for(j in 0..(n-1)){
            e[j]=list[i][j]
        }
        tensor[i]=e
    }
    return tensor
}
fun <T:Comparable<T>> getListOfList(tensor:Tensor<Tensor<T>>):List<List<T>>{
    var m=tensor.size()
    var vector:Vector<List<T>> =Vector(m)
    vector.setSize(m)
    for(i in 0..(m-1)){
        var list=tensor[i].toList()
        vector[i]=list
    }
    return vector.toList()
}
fun <T:Comparable<T>> getMutableListOfList(tensor:Tensor<Tensor<T>>):MutableList<List<T>>{
    var m=tensor.size()
    var vector:Vector<List<T>> =Vector(m)
    vector.setSize(m)
    for(i in 0..(m-1)){
        var list=tensor[i].toList()
        vector[i]=list
    }
    return vector.toMutableList()
}
fun <T:Comparable<T>> getMutableListOfMutableList(tensor:Tensor<Tensor<T>>):MutableList<MutableList<T>>{
    var m=tensor.size()
    var vector:Vector<MutableList<T>> =Vector(m)
    vector.setSize(m)
    for(i in 0..(m-1)){
        var list=tensor[i].toMutableList()
        vector[i]=list
    }
    return vector.toMutableList()
}
