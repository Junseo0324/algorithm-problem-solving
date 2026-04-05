package BOJ.euclidean

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }

    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun lcm(a: Int, b: Int): Int {
        return Math.abs(a * b) / gcd(a, b)
    }

    println(gcd(a,b))
    println(lcm(a,b))

}

