package BOJ.simulation

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = (1..n).toMutableList()
    repeat(m) {
        val (i,j) = readln().split(" ").map { it.toInt() }
        val slice = list.slice(i-1..j-1).reversed()
        for (idx in slice.indices) {
            list[idx+i-1] = slice[idx]
        }
    }

    println(list.joinToString(" "))
}