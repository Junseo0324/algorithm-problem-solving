package BOJ.dp

// https://www.acmicpc.net/problem/14501

/**
 * N+1 일째 되는날 퇴사
 * N일 동안 많은 상담 ㄱㄱ
 * 걸리는 시간 T 와 금액 P로 이루어져있다.
 * DP[i] = " i 번째 날부터 마지막 날(N일)까지 일했을 때 얻을 수 있는 최대 수익"
 */

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    val dp = IntArray(n + 2)
    repeat(n) {
        val (time, price) = readln().split(" ").map { it.toInt() }
        list.add(time to price)
    }

    for (i in n - 1 downTo 0) {
        val day = i + 1

        val time = list[i].first
        val price = list[i].second

        val endDay = day + time

        if (endDay > n + 1) {
            dp[day] = dp[day + 1]
        } else {
            val today = price + dp[endDay]
            val notToday = dp[day + 1]

            dp[day] = maxOf(today, notToday)
        }
    }

    println(dp[1])
}