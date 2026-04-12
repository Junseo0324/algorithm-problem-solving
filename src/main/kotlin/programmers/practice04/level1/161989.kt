package programmers.practice04.level1

fun main() {
    println(solution161989(8, 4, intArrayOf(2, 3, 6)))
    println(solution161989(5, 4, intArrayOf(1, 3)))
    println(solution161989(4, 1, intArrayOf(1, 2, 3, 4)))
}

fun solution161989(n: Int, m: Int, section: IntArray): Int {
    var answer = 0

    val wall = BooleanArray(n + 1) { true }

    section.forEach {
        wall[it] = false
    }
    for (i in wall.indices) {
        if (!wall[i]) {
            for (j in i until i+m) {
                if (j <= wall.size-1) {
                    wall[j] = true
                }
            }
            answer++
        }
    }
    return answer
}