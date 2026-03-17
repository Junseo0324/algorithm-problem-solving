package BOJ.trytty

/**
 * 0<=n<=99
 * 10 보다 작다면 앞에 0을 붙여 두자리수로 만들고, 각자리 더하기.
 * 주어진 수의 가장 오른쪽 자리 수
 */
fun main() {
    val n = readln().toInt()
    var current = n
    var count = 0

    while (true) {
        current = cycleNumber(current)
        count++

        if (current == n) break
    }

    println(count)
}

fun cycleNumber(num: Int): Int {
    val left = num / 10
    val right = num % 10
    val sum = left + right

    return (right * 10) + (sum % 10)
}