package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=kotlin

fun solution86491(sizes: Array<IntArray>): Int {
    val sortedSizes = sizes.map {
        it.sorted()
    }
    val width = sortedSizes.maxOfOrNull { it[0] } ?: 0
    val height = sortedSizes.maxOfOrNull { it[1] } ?: 0
    return width * height
}

fun main() {
    println(
        solution86491(
            arrayOf(
                intArrayOf(60, 50),
                intArrayOf(30, 70),
                intArrayOf(60, 30),
                intArrayOf(80, 40)
            )
        )
    )
}