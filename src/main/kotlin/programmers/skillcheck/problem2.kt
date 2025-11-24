package programmers.skillcheck

fun solution2(sequence: IntArray): Long {
    val dp = Array(sequence.size) { LongArray(2) }

    dp[0][0] = sequence[0].toLong()
    dp[0][1] = -1 * sequence[0].toLong()
    var answer = maxOf(dp[0][0], dp[0][1])

    for (i in 1 until sequence.size) {
        dp[i][0] = maxOf(sequence[i].toLong(), dp[i - 1][1] + sequence[i].toLong())
        dp[i][1] = maxOf(sequence[i].toLong(), dp[i - 1][0] - sequence[i].toLong())

        answer = maxOf(dp[i][0], answer)
        answer = maxOf(dp[i][1], answer)
    }

    return answer

}


fun main() {
    println(solution2(intArrayOf(2, 3, -6, 1, 3, -1, 2, 4))) // 10
}

