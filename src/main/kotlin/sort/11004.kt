package sort


//https://www.acmicpc.net/problem/11004

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val array = readln().split(" ").map { it.toInt() }.toMutableList()

    fun quickSelect(left: Int, right: Int, k: Int): Int {
        if (left == right) return array[left]

        var pivotIndex = partition(left, right,array)

        return when {
            k == pivotIndex -> array[k]
            k < pivotIndex -> quickSelect(left, pivotIndex - 1, k)
            else -> quickSelect(pivotIndex + 1, right, k)
        }
    }

    println(quickSelect(0, n - 1, m - 1))
}

fun partition(left: Int, right: Int,array: MutableList<Int>): Int {
    val pivot = array[right]
    var i = left

    for (j in left until right) {
        if (array[j] <= pivot) {
            array.swap(i, j)
            i++
        }
    }
    array.swap(i, right)
    return i
}

fun MutableList<Int>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}
