package BOJ.euclidean

fun main() {
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    val (n1,d1) = readln().split(" ").map { it.toInt() }
    val (n2,d2) = readln().split(" ").map { it.toInt() }

    var finalNumerator = n1 * d2 + n2 * d1
    var finalDenominator = d1 * d2

    val common = gcd(finalNumerator, finalDenominator)
    println("${finalNumerator / common} ${finalDenominator / common}")
}