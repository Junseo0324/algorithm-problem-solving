package BOJ.twopointer

fun main() {
    var (s, p) = readln().split(" ").map { it.toInt() }
    var str = readln()
    var countList = readln().split(" ").map { it.toInt() }
    //'A','C','G','T'

    var arr = IntArray(4) { 0 }
    var result = 0
    var idx = p

    repeat(p) {
        when (str[it]) {
            'A' -> arr[0]++
            'C' -> arr[1]++
            'G' -> arr[2]++
            'T' -> arr[3]++
        }
    }
    if (counting(arr, countList)) result++

    while (s > idx) {
        when (str[idx]) {
            'A' -> arr[0]++
            'C' -> arr[1]++
            'G' -> arr[2]++
            'T' -> arr[3]++
        }

        when (str[idx - p]) {
            'A' -> arr[0]--
            'C' -> arr[1]--
            'G' -> arr[2]--
            'T' -> arr[3]--
        }

        if (counting(arr, countList)) result++
        idx++
    }

    println(result)

}

fun counting(arr: IntArray, limit: List<Int>): Boolean {
    for (i in 0 until 4) {
        if (arr[i] < limit[i]) return false
    }
    return true
}