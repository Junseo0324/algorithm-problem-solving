package BOJ.trytty

fun main() {
    val n = readln().toInt()
    val aList = readln().split(" ").map { it.toInt() }.sorted()
    val bList = readln().split(" ").map { it.toInt() }.sortedDescending()

    var sum = 0

    for (i in 0 until n) {
        sum += aList[i] * bList[i]
    }

    println(sum)
}