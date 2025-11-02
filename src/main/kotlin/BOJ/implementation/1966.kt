package BOJ.implementation

// https://www.acmicpc.net/problem/1966

/**
 * 테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과,
 * 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)이 주어진다.
 * 이때 맨 왼쪽은 0번째라고 하자.
 * 두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다.
 * 중요도는 1 이상 9 이하의 정수이고,
 * 중요도가 같은 문서가 여러 개 있을 수도 있다.
 */
fun main() {
    repeat(readln().toInt()) {
        val (_, m) = readln().split(" ").map { it.toInt() }
        val priority = readln().split(" ").map { it.toInt() }
        val answer = mutableListOf<Int>()
        val queue = ArrayDeque<Pair<Int,Int>>()

        for (i in priority.indices) {
            queue.addLast(i to priority[i])
        }

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            if (queue.any { it.second > curr.second }) {
                queue.addLast(curr)
            } else {
                answer.add(curr.first)
            }
        }

        println(answer.indexOf(m)+1)

    }
}