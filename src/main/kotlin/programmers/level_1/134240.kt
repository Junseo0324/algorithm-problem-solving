package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/134240

fun solution134240(food: IntArray): String {
    var answer = ""
    for (i in 1..food.size-1) {
        answer += "$i".repeat(food[i]/2)
    }
    return answer + "0" + answer.reversed()
}


fun main() {
    println(solution134240(intArrayOf(1,7,1,2)))
}