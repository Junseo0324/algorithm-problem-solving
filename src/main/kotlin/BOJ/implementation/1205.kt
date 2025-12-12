package BOJ.implementation

fun main() {
    val (n, score, p) = readln().split(" ").map { it.toInt() }
    val array = mutableListOf<Int>()
    if (n > 0) {
        array += readln().split(" ").map { it.toInt() }.toList()
    } else {
        println(1)
        return
    }

    var isContain = false
    for (i in array.indices) {
        if (score > array[i]) {
            array += score
            isContain = true
            break
        }
    }

    if (!isContain) {
        if (array.size < p) {
            isContain = true
            array += score
        }
    }

    if (!isContain) {
        println(-1)
        return
    }

    val sortedList = if (array.size > p) {
        array.sortedDescending().dropLast(1)
    } else {
        array.sortedDescending()
    }

    var currentRank = 1
    val answerList = mutableListOf<Pair<Int, Int>>()
    answerList.add(currentRank to sortedList[0])
    for (i in 1 until sortedList.size) {
        val prev = answerList.last()

        if (prev.second == sortedList[i]) {
            answerList.add(currentRank to sortedList[i])
        } else {
            currentRank = i + 1
            answerList.add(currentRank to sortedList[i])
        }
    }

    answerList.find { it.second == score }?.let { println(it.first) }
}