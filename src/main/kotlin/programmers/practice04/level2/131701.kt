package programmers.practice04.level2

fun main() {
    println(solution131701(intArrayOf(7, 9, 1, 1, 4)))
}

fun solution131701(elements: IntArray): Int {
    val elementArray = elements + elements
    val set = mutableSetOf<Int>()

    for (i in 1..elements.size) {
        for (j in elements.indices) {
            var sum = 0
            for (k in j until j+i) {
                sum += elementArray[k]
            }
            set.add(sum)
        }
    }
    return set.size
}