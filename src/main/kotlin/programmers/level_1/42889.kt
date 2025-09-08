package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/42889

fun solution42889(N: Int, stages: IntArray): IntArray {
    var failedList = mutableListOf<Double>()
    for (i in 1..N) {
        var fail = 0
        var success = 0
        stages.forEach {
            if (it == i) {
                fail++
            } else if (it > i){
                success++
            }
        }
        if (fail + success > 0) {
            failedList.add(fail / (fail+success).toDouble())
        } else {
            failedList.add(0.0)
        }
    }
    return failedList.withIndex().sortedByDescending { it.value }.map { it.index+1 }.toIntArray()
}


fun main() {
    println(solution42889(5, intArrayOf(2,1,2,6,2,4,3,3)))
}