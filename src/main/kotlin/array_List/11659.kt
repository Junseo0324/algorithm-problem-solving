package array_List

fun main() {
    var (n,m) = readln().split(" ").map { it.toInt() }
    var arr = readln().split(" ").map { it.toInt() }
    var sumArr = IntArray(n+1)
    sumArr[0] = 0
    for (i in arr.indices) {
        sumArr[i+1] = sumArr[i] + arr[i]
    }
    repeat(m){
        var (i,j) = readln().split(" ").map { it.toInt() }
        println(sumArr[j] - sumArr[i-1])
    }
}