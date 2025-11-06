package BOJ.greedy

// https://www.acmicpc.net/problem/2457

/**
 * 3/1 ~ 11/30
 * 301 1201
 */


fun main() {
    val n = readln().toInt()
    var list = mutableListOf<Pair<Int, Int>>()
    var startDay = 301
    var endDay = 1201
    var answer = 0
    var i = 0

    repeat(n) {
        val (sX, sY, eX, eY) = readln().split(" ").map { it.toInt() }
        val start = sX * 100 + sY
        val end = eX * 100 + eY
        list.add(start to end)
    }

    list = list.sortedWith(compareBy<Pair<Int, Int>> {it.first}.thenByDescending { it.second }).toMutableList()

    while (startDay < endDay) {
        var maxEndDay = startDay
        var isFound = false

        while (i < n && list[i].first <= startDay) {
            if (list[i].second > maxEndDay) {
                maxEndDay = list[i].second
                isFound = true
            }
            i++
        }

        if (!isFound || maxEndDay == startDay) {
            answer = 0
            break
        }

        startDay = maxEndDay
        answer++
    }

    println(answer)

}