package programmers.practice.stack

fun main() {

    println(
        solution42587(
            priorities = intArrayOf(2, 1, 3, 2),
            location = 2
        )
    )
    println(
        solution42587(
            priorities = intArrayOf(1, 1, 9, 1, 1, 1),
            location = 0
        )
    )
}

fun solution42587(priorities: IntArray, location: Int): Int {
    val queue = ArrayDeque<Pair<Int, Int>>() // index, 값
    val list = mutableListOf<Pair<Int, Int>>()
    for (i in priorities.indices) {
        queue.add(i to priorities[i])
    }
    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()
        if (queue.any { it.second > curr.second }) {
            queue.addLast(curr)
        } else {
            list.add(curr)
        }
    }
    return list.indexOf(list.find { it.first == location }) + 1
}

