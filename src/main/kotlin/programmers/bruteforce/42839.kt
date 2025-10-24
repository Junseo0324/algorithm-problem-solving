package programmers.bruteforce

// https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=kotlin

fun solution42839(numbers: String): Int {
    val set = mutableSetOf<Int>()
    for (i in 1..numbers.length) {
        val data = permutations(numbers, i)
        set.addAll(data)
    }
    return set.count { isPrime(it) }
}

fun permutations(str: String, r: Int): List<Int> {
    val result = mutableListOf<Int>()
    val visited = BooleanArray(str.length)

    fun dfs(path: MutableList<Char>) {
        if (path.size == r) {
            val num = path.joinToString("").toInt()
            result.add(num)
            return
        }
        for (i in str.indices) {
            if (!visited[i]) {
                visited[i] = true
                path.add(str[i])
                dfs(path)
                path.removeLast()
                visited[i] = false
            }
        }
    }

    dfs(mutableListOf())
    return result
}

fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}

fun main() {
    println(solution42839("17"))
    println(solution42839("011"))
}