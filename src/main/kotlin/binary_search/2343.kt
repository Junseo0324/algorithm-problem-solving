package binary_search

fun main() {
    var (n, m) = readln().split(" ").map { it.toInt() }
    var list = readln().split(" ").map { it.toInt() }

    var low = list.maxOrNull() ?: 0
    var high = list.sum()
    var answer = high

    while (low <= high) {
        val mid = (low + high) / 2

        if (isPossible(mid, list, m)) {
            answer = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    println(answer)
}

fun isPossible(size: Int, list: List<Int>, m: Int): Boolean {
    var count = 1
    var currentSum = 0
    for (i in list) {
        if (currentSum + i > size) {
            count++
            currentSum = 0
        }
        currentSum += i
    }
    return count <= m
}