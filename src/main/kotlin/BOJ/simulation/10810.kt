package BOJ.simulation

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val array = IntArray(n) { 0 }

    repeat(m) {
        val (i, j, k) = readln().split(" ").map { it.toInt() }
        for (s in i..j) {
            array[s-1] = k
        }
    }
    println(array.joinToString(" "))
}