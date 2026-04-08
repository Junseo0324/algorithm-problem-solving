package programmers.practice04

fun main() {
    println(solution136798(5, 3, 2))
    println(solution136798(10, 3, 2))
}

fun solution136798(number: Int, limit: Int, power: Int): Int {
    var answer = 0
    for (i in 1..number) {
        val score = getCount(i)
        if (score > limit) {
            answer += power
        } else {
            answer += score
        }
    }
    return answer
}

fun getCount(num: Int): Int {
    var count = 0
    for (i in 1..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) {
            if (num / i == i) {
                count += 1
            } else {
                count += 2
            }
        }
    }
    return count
}