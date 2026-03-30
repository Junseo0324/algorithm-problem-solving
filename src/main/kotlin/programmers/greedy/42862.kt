package programmers.greedy

fun main() {
    println(
        solution42862(
            n = 5, lost = intArrayOf(2,4), reserve = intArrayOf(1,3,5)
        )
    )
    println(
        solution42862(
            n = 5, lost = intArrayOf(2,4), reserve = intArrayOf(3)
        )
    )
}

fun solution42862(n: Int, lost: IntArray, reserve: IntArray): Int {
    val lostList = lost.filter { it !in reserve }.sorted()
    val reserveList = reserve.filter { it !in lost }.toMutableList()

    var lostCount = lostList.size

    for (i in lostList) {
        if (i-1 in reserveList) {
            reserveList.remove(i-1)
            lostCount--
        } else if (i+1 in reserveList) {
            reserveList.remove(i+1)
            lostCount--
        }
    }

    return n-lostCount
}
