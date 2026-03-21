package BOJ.trytty

fun main() {
    val n = readln().toInt()
    val list = permutations10974((1..n).toList(),n)

    list.forEach {
        println(it.joinToString(" "))
    }
}

fun <T> permutations10974(list: List<T>, k: Int): List<List<T>> {
    val result = mutableListOf<List<T>>()
    val visited = BooleanArray(list.size)

    fun backtrack(current: MutableList<T>) {
        if (current.size == k) {
            result.add(current.toList())
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