package programmers.practice04

fun main() {
    println(solution12928(12))
}

fun solution12928(n: Int): Int {
    return (1..n).filter { n % it == 0 }.sum()
}