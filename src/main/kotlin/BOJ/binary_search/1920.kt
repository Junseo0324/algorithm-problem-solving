package BOJ.binary_search

/**
 * binarySearch 메소드 사용
 * 존재할 시 인덱스 값 반환 / 없으면 -1
 */
fun main() {
    var n = readln().toInt()
    var nArray = readln().split(" ").map { it.toInt() }.toIntArray()
    nArray.sort()
    var m = readln().toInt()
    var mArray = readln().split(" ").map { it.toInt() }.toIntArray()

    for (num in mArray) {
        val result = nArray.binarySearch(num)
//        println(result)
        println(if (result >=0) 1 else 0)
    }
}