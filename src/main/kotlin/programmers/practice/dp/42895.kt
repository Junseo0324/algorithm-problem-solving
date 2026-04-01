package programmers.practice.dp


fun main() {
    println(solution42895(N=5, number = 12))
    println(solution42895(N=2, number = 11))
}

fun solution42895(N: Int, number: Int): Int {
    if (N == number) return 1

    val dp = Array(9) { mutableSetOf<Int>() }
    for (i in 1..8) {
        val repeated = N.toString().repeat(i).toInt()
        dp[i].add(repeated)

        for (j in 1 until i) {
            for (a in dp[j]) {
                for (b in dp[i - j]) {
                    dp[i].add(a + b)
                    dp[i].add(a - b)
                    dp[i].add(a * b)
                    if (b != 0) dp[i].add(a / b)
                }
            }
        }

        if (dp[i].contains(number)) {
            return i
        }
    }
    return -1
}