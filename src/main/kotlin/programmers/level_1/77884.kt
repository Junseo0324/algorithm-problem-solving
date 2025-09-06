package programmers.level_1

import kotlin.math.sqrt

// https://school.programmers.co.kr/learn/courses/30/lessons/77884

fun solution77884(left: Int, right: Int): Int {
    var answer = 0
    for (i in left..right) {
       if ((1..i).count { i % it == 0 } %2 ==0) {
           answer +=i
       } else {
           answer -=i
       }
    }
    return answer
}


fun main() {
    println(solution77884(13, 17))
}