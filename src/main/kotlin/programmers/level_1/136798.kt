package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/136798?language=kotlin

/**
 * 10000 x 10000 = 100,000,000  = 10^9
 */
fun solution136798(number: Int, limit: Int, power: Int): Int {
    var answer= 0
    for (i in 1..number) {
        var count = 0
        for (j in 1..Math.sqrt(i.toDouble()).toInt()) {
            if (i % j == 0) {
                if (j * j == i) {
                    count+=1
                } else {
                    count += 2
                }
            }
        }
        if (count > limit) {
            answer += power
        } else {
            answer += count
        }
    }
    return answer
}

fun main() {
    println(solution136798(10,3,2))
}