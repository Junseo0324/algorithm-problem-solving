package BOJ.graph

// https://www.acmicpc.net/problem/9466

/**
 * 팀원 수 제한 x
 * 모든 학생들이 동일한 팀의 팀원인 겨우와 같이 한 팀만 있을 수 있다.
 * 모든 학생들은 프로젝트를 함께하고 싶은 학생을 선택 (단, 단 한명만 선택 가능)
 * 이미 확인을 다 한 것과 지금 확인 중인 사이클? 이라고 해야하나 그게 따로 있어야 할듯
 * 
 */
fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val array = intArrayOf(0) + readln().split(" ").map { it.toInt() }
        val visited = BooleanArray(n + 1)
        val checked = BooleanArray(n + 1)
        var answer = 0

        fun dfs(node: Int) {
            visited[node] = true
            val next = array[node]
            if (!visited[next]) {
                dfs(next)
            } else if (!checked[next]) {
                answer++
                var curr = array[next]
                while (curr != next) {
                    answer++
                    curr = array[curr]
                }
            }
            checked[node] = true
        }

        for (i in 1..n) {
            if (!visited[i]) {
                dfs(i)
            }
        }

        println(n - answer)
    }
}