package BOJ.euclidean


fun main() {
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun lcm(a: Int, b: Int): Int {
        return Math.abs(a * b) / gcd(a, b)
    }

    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println(lcm(a,b))
    }
}