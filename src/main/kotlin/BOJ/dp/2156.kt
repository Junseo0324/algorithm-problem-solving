package BOJ.dp

// https://www.acmicpc.net/problem/2156

fun main() {
    val n = readln().toInt()
    val wine = IntArray(n)
    repeat(n) {
        wine[it] = readln().toInt()
    }
    val dp = IntArray(n+1)

    if (n == 1) {
        println(wine[0])
        return
    }
    if (n == 2) {
        println(wine[0]+wine[1])
        return
    }

    dp[0] = 0
    dp[1] = wine[0]
    dp[2] = wine[0]+wine[1]

    for (i in 3..n) {
        dp[i] = maxOf(dp[i-1],dp[i-2]+wine[i-1],dp[i-3]+wine[i-2]+wine[i-1])
    }

    println(dp[n])
}