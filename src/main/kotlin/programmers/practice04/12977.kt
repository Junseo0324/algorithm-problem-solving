package programmers.practice04

fun main() {
    println(solution12977(intArrayOf(1, 2, 3, 4)))
    println(solution12977(intArrayOf(1, 2, 7, 6, 4)))
}

fun solution12977(nums: IntArray): Int {
    var answer = 0

    fun dfs(start:Int, depth: Int, sum: Int) {
        if (depth == 3) {
            if (isPrime(sum)) answer++
            return
        }

        for (i in start until nums.size) {
            dfs(i+1,depth+1,sum + nums[i])
        }
    }
    dfs(0,0,0)
    return answer
}

fun isPrime(num: Int): Boolean {
    if (num < 2) return false

    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}