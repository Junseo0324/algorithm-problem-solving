package programmers.practice.sort

fun main() {
    println(
        solution42746(
            numbers = intArrayOf(6, 10, 2)
        )
    )
    println(
        solution42746(
            numbers = intArrayOf(3, 30, 34, 5, 9)
        )
    )
}

fun solution42746(numbers: IntArray): String {
    val answer = numbers.map { it.toString() }.sortedWith { a,b -> (b+a).compareTo(a+b)}.joinToString("")
    return if (answer[0]!='0') answer else "0"
}