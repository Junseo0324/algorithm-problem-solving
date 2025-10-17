package BOJ.hash

// https://www.acmicpc.net/problem/17219

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val hashMap = mutableMapOf<String,String>()
    repeat(n) {
        val (address,pwd) = readln().split(" ")
        hashMap[address] = pwd
    }
    repeat(m) {
        println(hashMap[readln()])
    }
}