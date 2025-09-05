package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12935?language=kotlin

fun solution12935(arr: IntArray): IntArray {
    if (arr.size == 1) {
        return intArrayOf(-1)
    } else {
        return arr.filterNot { it == arr.minOrNull() }.toIntArray()
    }
}

fun main() {
    println(solution12935(intArrayOf(4,3,2,1)))
}