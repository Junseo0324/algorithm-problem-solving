package programmers.level_2

import kotlin.math.sqrt

// https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=kotlin

/**
 * 한 자리 숫자가 적힌 종이 조각
 * 종이 조각을 붙여 소수를 몇 개 만들 수 있는지?
 * 17 -> [1,7] 1,7,71 3개 만들 수 있음?
 * 0,1,1 -> 10,11,101,-> set?
 *
 * numbers -> 1~7 이하의 문자열
 * 0 ~ 9 로만 이루어짐.
 */

fun solution42839(numbers: String): Int {
    val list = numbers.map { it.toString() }
    val set = mutableSetOf<Int>()

    for (len in 1..list.size) {
        for (perm in list.permutations(len)) {
            val num = perm.joinToString("").toInt()
            set.add(num)
        }
    }

    return set.count { isPrime(it) }
}

fun isPrime(num: Int): Boolean {
    if (num <2) return false
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}


fun <T> List<T>.permutations(r: Int): List<List<T>> {
    val result = mutableListOf<List<T>>()
    val visited = BooleanArray(this.size)

    fun dfs(path: MutableList<T>) {
        if (path.size == r) {
            result.add(path.toList())
            return
        }
        for (i in indices) {
            if (!visited[i]) {
                visited[i] = true
                path.add(this[i])
                dfs(path)
                path.removeAt(path.lastIndex)
                visited[i] = false
            }
        }
    }
    dfs(mutableListOf())
    return result
}


fun main() {
    println(solution42839("17"))
    println(solution42839("011"))
}