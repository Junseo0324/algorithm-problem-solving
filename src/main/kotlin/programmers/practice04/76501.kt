package programmers.practice04

fun solution76501(absolutes: IntArray, signs: BooleanArray): Int {
    var answer: Int = 0
    for (i in absolutes.indices) {
        if (signs[i]) {
            answer += absolutes[i]
        } else {
            answer -= absolutes[i]
        }
    }
    return answer
}