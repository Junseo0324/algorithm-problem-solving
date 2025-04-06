package array_List

fun main() {
    var (n,m) = readln().split(" ").map { it.toInt() }
    var arr = readln().split(" ").map { it.toInt() }

    val dp = LongArray(n + 1)
    var cnt = LongArray(m)

    for (i in 1..n) {
        dp[i] = (arr[i - 1] + dp[i - 1]) % m
        cnt[dp[i].toInt()]++
    }

    var ans = cnt[0]
    for (i in 0 until m) {
        ans += cnt[i] * (cnt[i] - 1) / 2
    }
    println(ans)

}