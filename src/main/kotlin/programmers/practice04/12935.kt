package programmers.practice04

fun solution12935(arr: IntArray): IntArray {
    return if (arr.size ==1) {
        intArrayOf(-1)
    } else {
        arr.filterNot { it == arr.minOrNull() }.toIntArray()
    }
}