package BOJ.implementation

// https://www.acmicpc.net/problem/11866

/**
 * 1~n 원을 이루면서 앉아있다.
 *
 */

fun main() {
    val (n,k) = readln().split(" ").map { it.toInt() }

    val answer = mutableListOf<Int>()
    val queue = ArrayDeque((1..n).toList())

    while (queue.isNotEmpty()) {
        for (i in 0 until k) {
            val curr = queue.removeFirst()
            if (i == k-1) {
                answer.add(curr)
            } else {
                queue.addLast(curr)
            }
        }
    }

    println("<${answer.joinToString(", ")}>")

}