package BOJ.dp

// https://www.acmicpc.net/problem/15989
fun main() {
    val t = readln().toInt()
    val dp = IntArray(10001)
    dp[0] = 1
    for (num in 1..3) {
        for (i in num..10000) {
            dp[i] += dp[i-num]
        }
    }

    repeat(t) {
        val n = readln().toInt()
        println(dp[n])
    }
}