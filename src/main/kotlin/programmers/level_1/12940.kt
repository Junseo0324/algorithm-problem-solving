package programmers.level_1

import kotlin.math.abs

// https://school.programmers.co.kr/learn/courses/30/lessons/12940

fun solution12940(n: Int, m: Int): IntArray {
    var answer = intArrayOf(
        gcd(n,m), lcm(n,m)
    )
    return answer
}

fun gcd(n: Int, m: Int): Int {
    return if (m==0) n else gcd(m,n%m)
}

fun lcm(n: Int, m: Int): Int {
    return abs(n*m) / gcd(n,m)
}

fun main() {
    println(solution12940(3,12))
}