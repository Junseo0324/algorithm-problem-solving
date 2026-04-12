package programmers.practice04.level1

fun solution12922(n: Int): String {
    return if (n % 2 == 0) "수박".repeat(n / 2) else "수박".repeat(n/2) + "수"
}