package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/12914
/**
 * n칸이 주어질 때 1,2 를 활용한 가짓수 %1234567 리턴
 * 3칸 => 1,2 / 1,1,1, / 2,1
 * 5칸 -> 1,1,1,1,1 / 1,1,1,2 / 1,2,1,1 / 1,1,2,1 / 2,1,1,1 / 2,2,1 / 2,1,2 / 1,2,2,
 * 5 ->
 * dp[n] = dp[n-1]  + dp[n-2]
 */
fun solution12914(n: Int): Long {
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    if (n >=2) {
        dp[2] = 2
    }
    for (i in 3 .. n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
    }

    return dp[n].toLong()
}

fun main() {
    println(solution12914(1))
}