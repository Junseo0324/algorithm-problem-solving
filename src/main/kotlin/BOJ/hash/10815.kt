package BOJ.hash

//https://www.acmicpc.net/problem/10815

fun main() {
    readln().toInt()
    val nArr = readln().split(" ").map { it.toInt() }
    val hashMap = mutableMapOf<Int,Int>()
    nArr.forEach {
        hashMap[it] = hashMap.getOrDefault(it,0)+1
    }
    readln().toInt()
    val mArr = readln().split(" ").map { it.toInt() }

    println(mArr.map { if (hashMap.contains(it)) 1 else 0 }.joinToString(" "))
}