package programmers.practice04

fun main() {
    println(solution12912(a = 3, b = 5))
    println(solution12912(a = 3, b = 3))
    println(solution12912(a = 5, b = 3))
}

fun solution12912(a: Int, b: Int): Long {
    return if (a == b) {
        a.toLong()
    } else if (a > b) {
        (b.toLong()..a.toLong()).sum()
    } else {
        (a.toLong()..b.toLong()).sum()
    }
}