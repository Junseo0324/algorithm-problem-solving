package programmers.practice04.level2

fun main() {
    println(solution12914(4))
    println(solution12914(3))
}

fun solution12914(n: Int): Long {
    val dp = LongArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    if (n >=2) {
        dp[2] = 2
    }
    for (i in 3..n) {
        dp[i] = (dp[i-1]+dp[i-2]) % 1234567
    }
    return dp[n]
}