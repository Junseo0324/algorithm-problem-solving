package BOJ.implementation

// https://www.acmicpc.net/problem/1065

fun main() {
    val n = readln().toInt()
    var answer = 0
    if (n == 1000) {
        println(144)
        return
    }

    for (i in 1..n) {
        if (i < 100) {
            answer++
        } else {
            val a = i / 100
            val b = (i / 10) % 10
            val c = i % 10

            if ((a-b) == (b-c)) answer++
        }
    }

    println(answer)

}