package BOJ.hash

// https://www.acmicpc.net/problem/1764

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val nSet = mutableSetOf<String>()
    val mSet = mutableSetOf<String>()
    val answer = mutableListOf<String>()
    repeat(n) {
        nSet.add(readln())
    }
    repeat(m) {
        mSet.add(readln())
    }
    nSet.forEach{
        if (mSet.contains(it)) {
            answer.add(it)
        }
    }
    answer.sort()
    println(answer.size)
    answer.forEach {
        println(it)
    }
}