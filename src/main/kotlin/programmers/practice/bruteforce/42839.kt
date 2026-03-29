package programmers.practice.bruteforce

import kotlin.math.sqrt

fun main() {
    println(
        solution42839(
            numbers = "17"
        )
    )
    println(
        solution42839(
            numbers = "011"
        )
    )
}

fun solution42839(numbers: String): Int {
    val answer = mutableSetOf<Int>()
    val list = numbers.map { it.digitToInt() }

    for (i in list.indices) {
        val permutationList = permutations(list,i+1)
        permutationList.forEach {
            if (isPrime(it)) {
                answer.add(it)
            }
        }

    }
    return answer.size
}

fun isPrime(num: Int): Boolean {
    if (num <=1) return false
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }

    return true
}

fun permutations(list: List<Int>,k:Int): MutableList<Int> {
    val result = mutableListOf<Int>()
    val visited = BooleanArray(list.size)

    fun backtrack(current: MutableList<Int>) {
        if (current.size == k) {
            result.add(current.joinToString("").toInt())
            return
        }

        for (i in list.indices) {
            if (!visited[i]) {
                visited[i] = true
                current.add(list[i])

                backtrack(current)

                current.removeLast()
                visited[i] = false
            }
        }
    }

    backtrack(mutableListOf())
    return result
}

