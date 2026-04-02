package programmers.practice

fun main() {
    println(
        solution43238(
            n = 6,
            times = intArrayOf(7, 10)
        )
    )
}

fun solution43238(n: Int, times: IntArray): Long {
    var low = 1L
    var high = times.maxOrNull()!!.toLong() * n
    var answer: Long = high

    while (low <= high) {
        var mid = (low + high) / 2
        var total = 0L

        for (time in times) {
            total += mid / time
            if (total >= n) break
        }

        if (total >= n) {
            answer = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return answer
}