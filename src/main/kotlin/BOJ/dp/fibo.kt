package BOJ.dp

fun main() {
    val n = readln().toInt()

    val fibo = Array<Long>(50) {0}

    fibo[0] = 0
    fibo[1] = 1

    for ( i in 2..n) {
        fibo[i] = fibo[i-1]+fibo[i-2]
    }

    println(fibo[n])

}