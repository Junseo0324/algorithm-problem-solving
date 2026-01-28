package BOJ.simulation

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = (1..n).toMutableList()
    repeat(m) {
        val (i, j) = readln().split(" ").map { it.toInt() }
        val temp = list[i-1]
        list[i-1] = list[j-1]
        list[j-1] = temp
    }

    println(list.joinToString(" "))
}