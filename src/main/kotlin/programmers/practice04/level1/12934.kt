package programmers.practice04.level1

fun solution12934(n: Long): Long {
    for (i in 1..n) {
        if (i * i == n) {
            return ((i + 1) * (i + 1))
        }
    }
    return -1L
}