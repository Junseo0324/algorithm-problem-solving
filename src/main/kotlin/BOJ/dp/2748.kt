package BOJ.dp

// https://www.acmicpc.net/problem/2748

fun main() {
    val n = readln().toInt()

    val dp = LongArray(n + 1)

    if (n == 0) {
        println(0)
        return
    }
    if (n == 1) {
        println(1)
        return
    }
    dp[0] = 0
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    println(dp[n])
}