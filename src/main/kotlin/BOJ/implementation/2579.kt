package BOJ.implementation

import kotlin.math.max

// https://www.acmicpc.net/problem/2579

/**
 * 계단 오르는 데는 다음과 같은 규칙이 있다.
 *
 * 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
 * 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 * 연속된 세 개의 계단을 모두 밟아서는 안 된다.
 * 단, 시작점은 계단에 포함되지 않는다.
 * 마지막 도착 계단은 반드시 밟아야 한다.
 */
fun main() {
    val n = readln().toInt()
    val dp = Array(301) {0}
    val array = List(n) { readln().toInt() }
    dp[0] = 0
    if (n >= 1) {
        dp[1] = array[0]
    }
    if (n >= 2) {
        dp[2] = array[0] + array[1]
    }
    for (i in 3..n) {
        dp[i] = max(dp[i-2] + array[i-1], dp[i-3]+array[i-2]+array[i-1])
    }

    println(dp[n])
}