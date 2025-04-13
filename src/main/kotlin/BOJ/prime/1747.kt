package BOJ.prime

fun main() {
    var n = readln().toInt()

    fun isPrime(x: Int): Boolean {
        if (x == 1) return false
        for (i in 2..Math.sqrt(x.toDouble()).toInt()) {
            if (x%i==0) {
                return false
            }
        }
        return true
    }

    fun isPalindrome(x: Int): Boolean {
        val str = x.toString()
        return str == str.reversed()
    }

    while (true) {
        if (isPrime(n) && isPalindrome(n)) {
            println(n)
            break
        }
        n++
    }

}