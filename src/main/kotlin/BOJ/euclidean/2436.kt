package BOJ.euclidean

fun main() {
    fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }

    val (g, l) = readln().split(" ").map { it.toLong() }
    val target = g / l
    var resultA = 1L
    var resultB = target

    for (i in Math.sqrt(target.toDouble()).toLong() downTo 1L) {
        if (target % i == 0L) {
            val a = i
            val b = target / i

            if (gcd(a, b) == 1L) {
                resultA = a * g
                resultB = b * g
                break
            }
        }
    }
    println("$resultA $resultB")
}


