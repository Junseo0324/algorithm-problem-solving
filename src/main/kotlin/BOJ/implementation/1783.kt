package BOJ.implementation

/**
 * 2 위 1 오
 * 1 위 2 오
 * 1 아 2 오
 * 2 아 1 오
 */
fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }

    val result = when {
        n == 1 -> 1
        n == 2 -> {
            minOf(4,(m+1)/2)
        }
        else -> {
            if (m < 7) {
                minOf(4,m)
            } else {
                m-2
            }
        }
    }

    println(result)
}