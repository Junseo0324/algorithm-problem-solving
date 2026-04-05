package BOJ.euclidean

fun main() {
    fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }

    fun lcm(a: Long, b: Long): Long {
        return Math.abs(a*b) / gcd(a,b)
    }

    val (a,b) = readln().split(" ").map { it.toLong() }
    println(lcm(a,b))
}