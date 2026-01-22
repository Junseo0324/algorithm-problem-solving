package BOJ.implementation

fun main() {
    val arr = IntArray(9)
    repeat(9) {
        arr[it] = readln().toInt()
    }
    val maxNum = arr.max()
    println(maxNum)
    println(arr.indexOf(maxNum)+1)
}