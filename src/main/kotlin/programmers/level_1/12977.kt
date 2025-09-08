package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12977?language=kotlin
/**
 * nums < 50 -> 3개 50x50x50 = 125,000 완전탐색
 */
fun solution12977(nums: IntArray): Int {
    var answer = 0
    for (i in 0 until nums.size-2) {
        for (j in i+1 until nums.size-1) {
            for (k in j+1 until nums.size) {
                val sum = nums[i] + nums[j] + nums[k]
                if (isPrime(sum)) answer++
            }
        }
    }
    return answer
}

fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}

fun main() {
    println(solution12977(intArrayOf(1,2,3,4)))
}