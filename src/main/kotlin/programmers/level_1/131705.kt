package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/131705


fun solution131705(number: IntArray): Int {
    var answer: Int = 0
    for (i in 0..number.size-1) {
        for (j in i+1..number.size-1) {
            for (k in j+1..number.size-1) {
                if (number[i]+number[j]+number[k] == 0) {
                    println("number[$i]+number[$j]+number[$k] == ${number[i]}, ${number[j]},${number[k]}")
                    answer++
                }
            }
        }
    }
    return answer
}

fun main() {
    println(solution131705(intArrayOf(-2,3,0,2,-5)))
}