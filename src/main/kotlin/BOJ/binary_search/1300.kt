package BOJ.binary_search

fun main() {
    var n = readln().toInt()
    var m = readln().toInt()
    var low = 1L
    var high = n.toLong() * n.toLong()

    var answer= 0L

    while (low <= high) {
        val mid = (low+high) /2
        var count = 0L

        for (i in 1..n) {
            count += minOf(mid / i,n.toLong())
        }

        if (count < m) {
            low = mid+1
        } else {
            answer = mid
            high = mid-1
        }
    }

    println(answer)
}