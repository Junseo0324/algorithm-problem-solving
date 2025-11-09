package BOJ.dp

// https://www.acmicpc.net/submit/15486

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