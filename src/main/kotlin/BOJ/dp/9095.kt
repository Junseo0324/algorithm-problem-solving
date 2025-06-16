package BOJ.dp

/**
 * dp [0] = 0
 * dp[1] = 1
 * dp[2] = 2
 * dp[3] = 4
 * dp[4] = 7
 * dp[5] = 13
 * dp n = dp[n-1] + dp[n-2] + dp[n-3]
 * Fn = Fn-1 + Fn-2 + Fn-3
 */

fun main() {
    val m = readln().toInt()

    val dp = Array<Long>(20) { 0 }

    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4..16) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    repeat(m) {
        val n = readln().toInt()


        println(dp[n])
    }
}