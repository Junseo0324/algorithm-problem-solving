package BOJ.implementation

// https://www.acmicpc.net/problem/1003

/**
 * dp[n] = dp[n-1] + dp[n-2]
 */
fun main() {
    val n = readln().toInt()
    val dp = mutableListOf<Pair<Int,Int>>()

    dp.add(1 to 0)
    dp.add(0 to 1)
    dp.add(1 to 1)
    dp.add(1 to 2)

    for (i in 4..40) {
        val x = dp[i-1].first + dp[i-2].first
        val y = dp[i-1].second + dp[i-2].second
        dp.add(x to y)
    }

    repeat(n) {
        val (x,y) = dp[readln().toInt()]
        println("$x $y")
    }
}