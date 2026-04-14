package programmers.practice04.level2

fun main() {
    println(solution12953(intArrayOf(2, 6, 8, 14)))
    println(solution12953(intArrayOf(1, 2, 3)))
}

fun solution12953(arr: IntArray): Int {
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun lcm(a: Int, b: Int): Int {
        return Math.abs(a * b) / gcd(a, b)
    }

    var answer = arr[0]
    arr.sorted()
    for (i in 1 until arr.size) {
        answer = lcm(arr[i], answer)
    }
    return answer
}
