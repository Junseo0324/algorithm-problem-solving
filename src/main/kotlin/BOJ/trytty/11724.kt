package BOJ.trytty

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val list = List(n+1) { mutableListOf<Int>() }
    val visited = BooleanArray(n+1)

    repeat(m) {
        val data = readln().split(" ").map { it.toInt() }
        list[data[0]].add(data[1])
        list[data[1]].add(data[0])
    }


    fun dfs(node: Int) {
        visited[node] = true
        for (next in list[node]) {
            if (!visited[next]) {
                dfs(next)
            }
        }
    }

    var answer = 0
    for (i in 1..n) {
        if (!visited[i]) {
            dfs(i)
            answer++
        }

    }
    println(answer)

}
