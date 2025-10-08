package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/68645

fun solution68645(n: Int): IntArray {
    val answer = Array(n) { IntArray(n) { 0 } }

    val dx = intArrayOf(1, 0, -1)
    val dy = intArrayOf(0, 1, -1)

    var x = 0
    var y = 0
    var num = 1
    var dir = 0

    for (step in n downTo 1) {
        repeat(step) {
            answer[x][y] = num++

            if (it != step - 1) {
                x += dx[dir]
                y += dy[dir]
            }
        }

        dir = (dir+1) % 3

        x +=dx[dir]
        y +=dy[dir]
    }


    answer.forEach {
        println(it.joinToString(" "))
    }

    return answer.flatMap { it -> it.filterNot { it == 0 } }.toIntArray()
}

fun main() {
    println(solution68645(6))
}