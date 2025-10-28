package BOJ.graph

// https://www.acmicpc.net/problem/1697
/**
 * 수빈이는 1초 후에 X-1 or X+1로 이동 / 순간이동을 하는 경우는 2*x로 이동
 * x-1 , x+1 , 2*x
 * 0<=n<=100000
 */
fun main() {
    val (n,k) = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(100_001)
    var answer = 0

    fun bfs(start: Int) {
        val queue = ArrayDeque<Pair<Int,Int>>()
        queue.addLast(Pair(start,0))
        visited[start] = true
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            if (curr.first == k) {
                answer = curr.second
                return
            }
            if (curr.first +1 in 0..100_000 && !visited[curr.first+1]) {
                queue.addLast(Pair(curr.first+1, curr.second+1))
                visited[curr.first+1] = true
            }
            if (curr.first -1 in 0..100_000 && !visited[curr.first-1]) {
                queue.addLast(Pair(curr.first-1, curr.second+1))
                visited[curr.first-1] = true
            }
            if (curr.first *2 in 0..100_000 && !visited[curr.first *2]) {
                queue.addLast(Pair(curr.first *2, curr.second+1))
                visited[curr.first *2] = true
            }
        }
    }

    bfs(n)
    println(answer)
}