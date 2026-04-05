package BOJ.euclidean

fun main() {
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    repeat(readln().toInt()) {
        val list = readln().split(" ").map { it.toInt() }.toMutableList().drop(1)

        var answer = 0L

        for (i in 0 until list.size - 1) {
            for (j in i+1 until list.size) {
                answer += gcd(list[i],list[j])
            }
        }
        println(answer)
    }
}