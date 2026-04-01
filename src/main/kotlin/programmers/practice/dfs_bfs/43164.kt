package programmers.practice.dfs_bfs

fun main() {
    println(
        solution43164(
            tickets = arrayOf(
                arrayOf("ICN", "JFK"),
                arrayOf("HND", "IAD"),
                arrayOf("JFK", "HND"),
            )
        )
    )
    println(
        solution43164(
            tickets = arrayOf(
                arrayOf("ICN", "SFO"),
                arrayOf("ICN", "ATL"),
                arrayOf("SFO", "ATL"),
                arrayOf("ATL", "ICN"),
                arrayOf("ATL","SFO"),
            )
        )
    )
}

fun solution43164(tickets: Array<Array<String>>): List<String> {
    var answer = listOf<String>()
    val graph = mutableMapOf<String,MutableList<String>>()
    val visited = mutableMapOf<String,BooleanArray>()

    for ((start,destination) in tickets) {
        val list = graph.getOrDefault(start, mutableListOf())
        list.add(destination)
        graph[start] = list
    }
    graph.values.forEach { it.sort() }
    graph.forEach { key, value ->
        visited[key] = BooleanArray(value.size)
    }
    var isFind = false
    fun dfs(start: String, path: MutableList<String>,count: Int) {
        if (isFind) return

        if (count == tickets.size) {
            answer = path.toList()
            isFind = true
            return
        }

        val destinations = graph[start] ?: return
        val checks = visited[start] ?: return

        for (i in destinations.indices) {
            if (!checks[i]) {
                checks[i] = true
                path.add(destinations[i])

                dfs(destinations[i], path, count + 1)

                path.removeAt(path.size - 1)
                checks[i] = false
            }
        }
    }

    dfs("ICN", mutableListOf("ICN"),0)
    return answer
}