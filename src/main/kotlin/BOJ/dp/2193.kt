package BOJ.dp

// https://www.acmicpc.net/problem/2193

fun main() {
    val n = readln().toInt()
    if (n == 1) {
        println(1)
        return
    }
    if (n == 2) {
        println(1)
        return
    }

    val dp = LongArray(n + 1)

    dp[0] = 1
    dp[1] = 1
    dp[2] = 1
    for (i in 3..n) {
        for (j in 0..i-2) {
            dp[i] += dp[j]
        }
    }
    println(dp[n])
}