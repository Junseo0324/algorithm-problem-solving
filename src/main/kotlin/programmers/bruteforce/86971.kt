package programmers.bruteforce

// https://school.programmers.co.kr/learn/courses/30/lessons/86971?language=kotlin

/**
 * n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있음.
 * 이 전선 중 하나를 끊어 현재의 전력망네트워크를 2개로 분할할려고 한다.
 * 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 함
 * 송전탑 개수 n
 * 전선 정보 wires
 * 두 전력망이 가지고 있 송전탑 개수의 차이를 절댓값으로 return
 *
 *  n<100
 *  wires < 99
 * dfs 로 접근해야 하네..
 */
fun solution86971(n: Int, wires: Array<IntArray>): Int {
    var answer = Int.MAX_VALUE
    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (wire in wires) {
        val (a, b) = wire
        graph[a].add(b)
        graph[b].add(a)
    }
    fun dfs(node: Int, visited: BooleanArray): Int {
        visited[node] = true
        var count = 1

        for (neighbor in graph[node]){
            if (!visited[neighbor]) {
                count += dfs(neighbor,visited)
            }
        }
        return count
    }
    for ((a,b) in wires) {
        val visited = BooleanArray(n+1)
        visited[b] = true
        val countA = dfs(a,visited)
        val countB = n - countA
        answer = minOf(answer,Math.abs(countA - countB))
    }

    return answer
}

fun main() {
    println(
        solution86971(
            9,
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(4, 6),
                intArrayOf(4, 7),
                intArrayOf(7, 8),
                intArrayOf(7, 9)
            )
        )
    )

    println(
        solution86971(
            4,
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
            )
        )
    )

    println(
        solution86971(
            7,
            arrayOf(
                intArrayOf(1,2),
                intArrayOf(2,7),
                intArrayOf(3,7),
                intArrayOf(3,4),
                intArrayOf(4,5),
                intArrayOf(6,7)
            )
        )
    )
}