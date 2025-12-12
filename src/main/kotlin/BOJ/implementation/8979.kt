package BOJ.implementation

// https://www.acmicpc.net/problem/8979

/**
 * 1. 금메달이 더 많은 나라
 * 2. 금메달이 같다면 은메달이 더 많은 나라
 * 3. 금,은 이 같다면 동메달이 더 많은 나라
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(n) }
    repeat(n) {
        array[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val answerList = array.sortedWith(compareByDescending<IntArray> { it[1] }.thenByDescending { it[2] }.thenByDescending { it[3] })

    val rankedList = mutableListOf<Pair<Int,IntArray>>()

    var currentRank = 1
    if (answerList.isNotEmpty()) {
        rankedList.add(Pair(currentRank, answerList[0]))
    }


    for (i in 1 until answerList.size) {
        val prevItem = answerList[i - 1]
        val currentItem = answerList[i]

        val isSameRank = compareByDescending<IntArray> { it[1] }.thenByDescending { it[2] }.thenByDescending { it[3] }.compare(currentItem, prevItem) == 0

        if (isSameRank) {
            rankedList.add(Pair(currentRank, currentItem))
        } else {
            currentRank = i + 1
            rankedList.add(Pair(currentRank, currentItem))
        }
    }

    val targetCountryRank = rankedList.find { it.second[0] == k }?.first

    println(targetCountryRank)
}