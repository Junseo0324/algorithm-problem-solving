package BOJ.trytty

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()

    val perms = permutations(list,n)
    var answer = 0

    for (data in perms) {
        answer = maxOf(answer,calculate(data))
    }

    println(answer)

}

fun calculate(list: List<Int>): Int {
    var sum = 0
    for (i in 0 until list.size-1) {
        sum += abs(list[i] - list[i+1])
    }

    return sum
}

fun <T> permutations(list: MutableList<T>, k: Int): List<List<T>> {
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