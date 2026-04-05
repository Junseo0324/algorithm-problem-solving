package BOJ.euclidean

fun main() {
    fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }
    val (a, b) = readln().split(" ").map { it.toLong() }

    val count = gcd(a, b)

    println("1".repeat(count.toInt()))
}