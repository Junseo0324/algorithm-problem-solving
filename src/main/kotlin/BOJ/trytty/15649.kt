package BOJ.trytty

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val list = permutations15649((1..n).toMutableList(), m)

    println(list.flatten().joinToString("\n"))
}


fun <T> permutations15649(list: MutableList<T>, k: Int): List<List<T>> {
    val result = mutableListOf<List<T>>()
    val visited = BooleanArray(list.size)

    fun backtrack(current: MutableList<T>) {
        if (current.size == k) {
            result.add(current.toList())
            return
        }

        for (i in list.indices) {
            if (!visited[i]) {
                visited[i] = true
                current.add(list[i])

                backtrack(current)

                current.removeAt(current.size - 1)
                visited[i] = false
            }
        }
    }

    backtrack(mutableListOf())
    return result
}