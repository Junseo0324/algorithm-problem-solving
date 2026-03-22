package BOJ.trytty

/**
 * x 구멍의 너비 cm
 * n 레고의 길이
 * l 레고 조각의 길이
 * 10 센티미터 (100000000 나노미터
 */
fun main() {
    while (true) {
        val input = readlnOrNull() ?: break
        val x = input.toLong() * 10_000_000
        val n = readln().toInt()
        val array = LongArray(n) { readln().toLong() }

        array.sort()

        var left = 0
        var right = n-1

        var isFind = false
        var a = 0L
        var b = 0L

        while (left < right) {
            val sum = array[left] + array[right]

            if (sum == x) {
                a = array[left]
                b = array[right]
                isFind = true
                break
            } else if (sum < x) {
                left++
            } else {
                right--
            }
        }

        if (isFind) {
            println("yes $a $b")
        } else {
            println("danger")
        }


    }
}