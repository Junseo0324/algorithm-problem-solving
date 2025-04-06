package dfs

import kotlin.math.sqrt

/**
 * 7331 -> 모든 자리가 소수
        733 , 73 , 7
        왼쪽부터 1,2,3,4자리 모두 소수
 * N의 자리를 나타내는 N이 주어졌을 때 N의 자리 숫자 중 신기한 소수를 찾기.
 * 시간 제한 : 2초
 * 한 자리 소수 : 2,3,5,7
 * 그 다음에 붙었을 때 소수가 될 수 있는 수(홀수) : 1,3,5,7,9
 * for -> dfs( num * 10 + 다음 홀수)
 */
fun main() {
    val n = readln().toInt()
    fun dfs(num: Int, m: Int) {
        if (m == n) {
            if (isPrime(num)) {
                println(num)
            }
            return
        }
        for (i in 1..9 step 2) {
            if (isPrime(num*10 + i)) {
                dfs(num*10 +i,m+1)
            }
        }
    }

    dfs(2,1)
    dfs(3,1)
    dfs(5,1)
    dfs(7,1)
}

fun isPrime(x: Int): Boolean {
    for (i in 2..sqrt(x.toDouble()).toInt()) {
        if (x % i==0) {
            return false
        }
    }
    return true
}