package programmers.practice.bruteforce

fun main() {
    println(
        solution86491(
            sizes = arrayOf(
                intArrayOf(60,50),
                intArrayOf(30,70),
                intArrayOf(60,30),
                intArrayOf(80,40),
            )
        )
    )
    println(
        solution86491(
            sizes = arrayOf(
                intArrayOf(10,7),
                intArrayOf(12,3),
                intArrayOf(8,15),
                intArrayOf(14,7),
                intArrayOf(5,15),
            )
        )
    )
    println(
        solution86491(
            sizes = arrayOf(
                intArrayOf(14,4),
                intArrayOf(19,6),
                intArrayOf(6,16),
                intArrayOf(18,7),
                intArrayOf(7,11),
            )
        )
    )
}

fun solution86491(sizes: Array<IntArray>): Int {
    val sortedList = sizes.map { it.sorted() }

    var width = 0
    var height = 0

    for (size in sortedList) {
        width = maxOf(width,size[0])
        height = maxOf(height,size[1])
    }
    return width * height
}