package BOJ.dp

/**
 * P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
 * dp[1] = 1
 * dp[2] = 1
 * dp[3] = 1
 * dp[4] = 2 - /1 + 3/
 * dp[5] = 2 -
 * dp[6] = 3 - / 5+1
 * dp[7] = 4 / 6+2
 * dp[8] = 5 / 7+3
 * dp[9] = 7 / 8+4
 * F(n) = F(n-1) + F(n-5) (n>5)
 */
fun main() {
    val T = readln().toInt()
    val dp = Array<Long>(101) {0}
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    dp[5] = 2

    repeat(T) {
        val n = readln().toInt()
        for (i in 6..n) {
            dp[i] = dp[i-1] + dp[i-5]
        }

        println(dp[n])
    }
}