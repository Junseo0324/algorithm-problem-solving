package programmers.stack_queue

// https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=kotlin

fun solution42587(priorities: IntArray, location: Int): Int {
    val q = ArrayDeque<Pair<Int,Int>>()
    for (i in priorities.indices) {
        q.addLast(Pair(i,priorities[i]))
    }
    val list = mutableListOf<Int>()

    while (q.isNotEmpty()) {
        var priority = q.first().second
        if (q.any { it.second > priority }) {
            val curr = q.removeFirst()
            q.addLast(curr)
        } else {
            val curr = q.removeFirst()
            list.add(curr.first)
        }
    }

    return list.indexOf(location)+1
}

fun main() {
    println(solution42587(intArrayOf(2, 1, 3, 2), 2))
    println(solution42587(intArrayOf(1, 1, 9, 1, 1, 1), 0))
}