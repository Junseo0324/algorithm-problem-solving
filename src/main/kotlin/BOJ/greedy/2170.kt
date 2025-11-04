package BOJ.greedy

// https://www.acmicpc.net/problem/2170

fun main() {
    val n = readln().toInt()
    var array = mutableListOf<Pair<Int, Int>>()
    var answer = mutableListOf<Pair<Int, Int>>()
    var length = 0
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        array.add(x to y)
    }

    array = array.sortedWith(compareBy { it.first }).toMutableList()


    array.forEach { (x, y) ->
        if (answer.isNotEmpty()) {
            var (currX, currY) = answer.removeLast()
            if (currY > x) {
                if (currY < y) {
                    currY = y
                }
                answer.add(currX to currY)

            } else {
                answer.add(currX to currY)
                answer.add(x to y)
            }
        } else {
            answer.add(x to y)
        }
    }
    answer.forEach { (x, y) ->
        length += (y - x)
    }
    println(length)
}