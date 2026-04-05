package BOJ.implementation

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    val distanceList = mutableListOf<Int>()
    repeat(n) {
        list.add(readln().toInt())
    }
    for (i in 0 until list.size - 1) {
        distanceList.add(list[i + 1] - list[i])
    }

    val minDistance = distanceList.reduce { acc, next -> gcd(acc,next) }

    val answer = distanceList.map { (it / minDistance) - 1 }.sum()
    println(answer)
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}