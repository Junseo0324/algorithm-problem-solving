package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/12945

/**
 * F(0) = 0 , F(1) = 1 , F(n) = F(n-1) + F(n-2)
 */
fun solution12945(n: Int): Int {
    val dp = IntArray(n+1)
    dp[0] = 0
    dp[1] = 1
    for (i in 2 until dp.size) {
        dp[i] = (dp[i-1] + dp[i-2]) % 1234567
    }

    return dp[n]
}


fun main() {
    println(solution12945(5))
}
