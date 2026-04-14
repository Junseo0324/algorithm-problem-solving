package programmers.practice04.level2

fun main() {
    println(solution138476(6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
    println(solution138476(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
    println(solution138476(2, intArrayOf(1, 1, 1, 1, 2, 2, 2, 3)))
}

fun solution138476(k: Int, tangerine: IntArray): Int {
    var answer = 0
    val hashMap = mutableMapOf<Int, Int>()

    for (data in tangerine) {
        hashMap[data] = hashMap.getOrDefault(data, 0) + 1
    }
    val sortedList = hashMap.entries.sortedByDescending { it.value }
    var count = k
    for ((_, amount) in sortedList) {
        if (count > 0) {
            count -= amount
            answer++
        }
    }
    return answer
}