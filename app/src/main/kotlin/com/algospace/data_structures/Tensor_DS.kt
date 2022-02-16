package com.algospace.data_structures
import kotlin.math.*
import kotlin.collections.*
import java.util.*
class Tensor<T:Comparable<T>>(var n:Int,var defaultValue:T?):Comparable<Tensor<T>>{
    var a:Vector<T?> = Vector(n) 
    init{
        a.setSize(n)
        for(i in 0..(n-1))a[i]=defaultValue
        n=a.capacity()
        if(n==0){
            n=2
            a.ensureCapacity(2)
        }
    }
    constructor():this(0,null)
    constructor(n:Int):this(n,null)
    override fun compareTo(other:Tensor<T>):Int{
        var ans=0
        var m=minOf(this.size(),other.size())
        for(i in 0..(m-1)){
            if(this[i].compareTo(other[i])==-1){
                ans=-1
                break
            }
            else if(this[i].compareTo(other[i])==1){
                ans=1
                break
            }
        }
        if(ans==0){
            if(this.size()<other.size())ans=-1
            else if(this.size()>other.size())ans=1
        }
        return ans
    }
    fun add(e:T){
        if((a.size)==n){
            n*=2
            n=minOf(n,8200)
            a.ensureCapacity(n)
        }
        a.add(e)
    }
    fun add(index:Int,e:T){
        if((a.size)==n){
            n*=2
            n=minOf(n,8200)
            a.ensureCapacity(n)
        }
        a.add(index,e)
    }
    fun back():T{
        if(a.size==0){
            if(defaultValue==null)
             println("Empty Tensor, Be careful")
            else
             return defaultValue!!    
        }
        var m:Int =a.size
        return a.get(m-1)!!
    }
    fun clear(){a.clear()}
    fun clone():Tensor<T>{
        var m:Int=a.size
        var newTensor:Tensor<T> =Tensor(n,defaultValue)
        for(i in 0..(m-1))newTensor[i]=this[i]
        return newTensor
    }
    fun empty():Boolean{
        if(a.size==0)
            return true
        return false
    }
    fun ensureCapacity(minCapacity:Int){a.ensureCapacity(minCapacity)}
    operator fun get(index:Int):T{
        if(index<0 || index>=(this.size())){
           if(defaultValue==null)println("Null defaultValue, Be careful")
           else
             return defaultValue!!
        }
        return this.a[index]!!
    }
    fun front():T{
        if(a.size ==0) {
            if(defaultValue==null){
               println("Empty Tensor, Be careful")
            }
            else return defaultValue!!
        }
        return a.get(0)!!
    }
    fun push_back(e:T){
        if((a.size)==n){
            n*=2
            n=minOf(n,8200)
            a.ensureCapacity(n)
        }
        a.add(e)
    }
    fun push_front(e:T){this.add(0,e)}
    fun pop_back(){this.removeAt(a.size-1)}
    fun pop_front(){this.removeAt(0)}
    fun removeAt(index:Int){
        if(index>=0 && index<a.size)
           a.removeAt(index)
    }
    operator fun set(index:Int, e:T){a.set(index,e)}
    fun setDefault(e:T){this.defaultValue=e}
    fun size():Int{ return a.size}
    fun toList():List<T>{
        var m=this.size()
        var vector:Vector<T> =Vector(m)
        for(i in 0..(m-1))vector[i]=this[i]
        return vector.toList()
    }
    fun toMutableList():MutableList<T>{
        var m=this.size()
        var vector:Vector<T> =Vector(m)
        for(i in 0..(m-1))vector[i]=this[i]
        return vector.toMutableList()
    }
}
