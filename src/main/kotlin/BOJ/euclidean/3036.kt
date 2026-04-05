package BOJ.euclidean

fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }

    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    for (i in 1 until list.size) {
        val common = gcd(list[0],list[i])
        println("${list[0]/common}/${list[i]/common}")
    }

}