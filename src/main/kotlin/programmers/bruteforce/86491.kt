package programmers.bruteforce

// https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=kotlin

fun solution86491(sizes: Array<IntArray>): Int {
    var width = 0
    var height = 0

    sizes.forEach {
        if (it[0] > it[1]) {
            width = Math.max(width,it[0])
            height = Math.max(height,it[1])
        } else {
            width = Math.max(width,it[1])
            height = Math.max(height,it[0])
        }
    }
    return width * height
}

fun main() {
    println(solution86491(
        arrayOf(
            intArrayOf(60,50),
            intArrayOf(30,70),
            intArrayOf(60,30),
            intArrayOf(80,40),
        )
    ))
    println(solution86491(
        arrayOf(
            intArrayOf(10,7),
            intArrayOf(12,3),
            intArrayOf(8,15),
            intArrayOf(14,7),
            intArrayOf(5,15)
        )
    ))
    println(solution86491(
        arrayOf(
            intArrayOf(14,4),
            intArrayOf(19,6),
            intArrayOf(6,16),
            intArrayOf(18,7),
            intArrayOf(7,11),
        )
    ))
}