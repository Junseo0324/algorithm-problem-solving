package programmers.practice.stack

fun main() {

    println(
        solution42586(
            progresses = intArrayOf(93, 30, 55),
            speeds = intArrayOf(1, 30, 5)
        )
    )
    println(
        solution42586(
            progresses = intArrayOf(95, 90, 99, 99, 80, 99),
            speeds = intArrayOf(1, 1, 1, 1, 1, 1)
        )
    )
}

fun solution42586(progresses: IntArray, speeds: IntArray): MutableList<Int> {
    var answer = mutableListOf<Int>()

    val queue = ArrayDeque<Int>()

    for (i in progresses.indices) {
        val remain = (100 - progresses[i] + speeds[i] - 1) / speeds[i]
        queue.addLast(remain)
    }

    while (queue.isNotEmpty()) {
        val day = queue.removeFirst()
        var count = 1
        while (queue.isNotEmpty() && queue.first() <= day) {
            queue.removeFirst()
            count++
        }
        answer.add(count)
    }
    return answer
}
