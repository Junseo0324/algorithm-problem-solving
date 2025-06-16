package BOJ.dp

import kotlin.math.max

fun main() {
    val str = readln()
    val str2 = readln()
    val dp = Array(1010) { Array(1010) { 0L } }

    for (i in 1..str.length) {
        for (j in 1..str2.length) {
            //각 문자가 같을 때
            if (str[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i-1][j-1]+1
            } else {
                //각 문자가 다를 때
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])
            }

        }
    }

    println(dp[str.length][str2.length])
}