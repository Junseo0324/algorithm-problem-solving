package BOJ.hash

// https://www.acmicpc.net/problem/14425

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val nSet = mutableSetOf<String>()
    val mArr = mutableListOf<String>()
    var answer = 0
    repeat(n) {
        nSet.add(readln())
    }
    repeat(m) {
        mArr.add(readln())
    }
    mArr.forEach {
        if (nSet.contains(it)) {
            answer++
        }
    }
    println(answer)
}