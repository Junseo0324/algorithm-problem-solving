package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/76501?language=kotlin

fun solution76501(absolutes: IntArray, signs: BooleanArray): Int {
    var answer = 0
    for (i in 0 until absolutes.size) {
        if (signs[i]) {
            answer += absolutes[i]
        } else {
            answer -= absolutes[i]
        }
    }
    return answer
}

fun main() {
    println(solution76501(intArrayOf(4,7,12), booleanArrayOf(true,false,true)))
}


