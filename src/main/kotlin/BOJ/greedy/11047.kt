package BOJ.greedy

/**
 * 큰 것부터 나누면 된다.
 */
fun main() {
    var (n, k) = readln().split(" ").map { it.toInt() }
    var list = mutableListOf<Int>()
    repeat(n) {
        list += readln().toInt()
    }

    var count = 0
    list.sortDescending()

    for (i in list.indices) {
        if (k >= list[i]) {
            count += (k / list[i])
            k %= list[i];
        }
    }
    println(count)
}