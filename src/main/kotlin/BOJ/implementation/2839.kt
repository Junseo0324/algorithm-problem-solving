package BOJ.implementation

// https://www.acmicpc.net/problem/2839

fun main() {
    val n = readln().toInt()
    var answer = -1
    var bigCount = n / 5

    while (bigCount >=0) {
        val remaining = n -(bigCount * 5)

        if (remaining % 3 == 0) {
            val threeKgCount = remaining / 3
            answer = bigCount + threeKgCount
            break
        }

        bigCount--

    }

    println(answer)

}