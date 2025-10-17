package BOJ.hash

//https://www.acmicpc.net/problem/10816
/**
 *  1<N<500000
 */
fun main() {
    readln().toInt()
    val hashMap = mutableMapOf<Int,Int>()
    val data = readln().split(" ").map { it.toInt() }

    data.forEach {
        hashMap[it] = hashMap.getOrDefault(it,0)+1
    }
    readln().toInt()

    val mArr = readln().split(" ").map { it.toInt() }

    val result = mArr.map {
        hashMap.getOrDefault(it,0)
    }.joinToString(" ")
    println(result)

}