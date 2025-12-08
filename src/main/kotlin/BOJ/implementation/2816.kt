package BOJ.implementation

// https://www.acmicpc.net/problem/2816


fun main() {
    val n = readln().toInt()
    val array = MutableList(n) {""}
    var oneCount = 0
    var twoCount = 0

    var answer = ""

    for (i in 0 until n) {
        val input = readln()
        if (input == "KBS1") {
            oneCount = i
        } else if (input == "KBS2") {
            twoCount = i
        }
        array[i] = input
    }

    if (twoCount > oneCount) oneCount++

    answer += "1".repeat(twoCount)
    answer += "4".repeat(twoCount)
    answer += "1".repeat(oneCount)
    answer += "4".repeat(oneCount)

    println(answer)

}