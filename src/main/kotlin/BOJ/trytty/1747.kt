package BOJ.trytty

/**
 * n보다 크거나 같고, 소수이면서 팰린드롬인 수 중 가장 작은 수를 구해라.
 * 1<=n<=10^6
 */
fun main() {
    val n = readln().toInt()
    var i = n
    while (true) {
        if (isPrime(i) && isPalindrome(i)) {
            println(i)
            break
        }
        i++
    }
}

fun isPrime(num: Int): Boolean {
    if (num == 0 || num == 1) return false
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}

fun isPalindrome(num: Int): Boolean {
    val str = num.toString()
    val reverse = str.reversed()

    return str == reverse
}