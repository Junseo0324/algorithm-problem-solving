package BOJ.stack

// https://www.acmicpc.net/problem/6198
/**
 * 1 < n < 80,000
 * 막힐 때까지 간다.
 *
 */
fun main() {
    val n = readln().toInt()
    val stack = mutableListOf<Int>()
    var answer = 0L

    repeat(n) {
        val curr = readln().toInt()

        while (stack.isNotEmpty() && stack.last() <= curr) {
            stack.removeLast()
        }
        answer += stack.size
        stack.add(curr)
    }

    println(answer)
}