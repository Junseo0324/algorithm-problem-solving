package BOJ.bd_seven

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val list = permutations((1..n).toMutableList(),m)

    list.forEach {
        println(it.joinToString(" "))
    }
}

fun permutations(list: MutableList<Int>,k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val visited = BooleanArray(list.size)

    fun backtrack(current: MutableList<Int>) {
        if (current.size == k) {
            result.add(current.toList())
            return
        }

        for (i in list.indices) {
            if (!visited[i]) {
                visited[i] = true
                current.add(list[i])

                backtrack(current)

                current.removeAt(current.size-1)
                visited[i] = false
            }
        }
    }

    backtrack(mutableListOf())

    return result
}