package BOJ.prime

fun main() {
    var (m,n) = readln().split(" ").map { it.toInt() }

    for (i in m..n) {
        if (isPrime(i)) {
            println(i)
        }
    }
}

fun isPrime(x: Int): Boolean {
    if (x == 1) return false
    for (i in 2..Math.sqrt(x.toDouble()).toInt()) {
        if (x%i ==0) {
            return false
        }
    }
    return true
}