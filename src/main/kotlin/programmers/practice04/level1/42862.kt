package programmers.practice04.level1

fun main() {
    println(solution42862(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    println(solution42862(5, intArrayOf(2, 4), intArrayOf(3)))
    println(solution42862(3, intArrayOf(3), intArrayOf(1)))
    println(solution42862(3, intArrayOf(3), intArrayOf(1, 3)))
}

fun solution42862(n: Int, lost: IntArray, reserve: IntArray): Int {
    val lostList = lost.filter { it !in reserve }.sorted()
    val reserveList = reserve.filter { it !in lost }.toMutableList()

    var lostCount = lostList.size
    for (student in lostList) {
        if (student - 1 in reserveList) {
            reserveList.remove(student - 1)
            lostCount--
        } else if (student + 1 in reserveList) {
            reserveList.remove(student + 1)
            lostCount--
        }
    }

    return n - lostCount
}