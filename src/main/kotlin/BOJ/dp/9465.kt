package BOJ.dp

// https://www.acmicpc.net/problem/9465

/**
 * 스티커를 때면 변을 공유하는 스티커는 모두 찢어져 사용할 수 없다. 즉 뗀 스티커의 왼,오,위,아래를 사용할 수 없다.
 */
fun main() {
    val T = readln().toInt()
    repeat(T) {
        val n = readln().toInt()
        val array = Array(2) { IntArray(n) }
        array[0] = readln().split(" ").map { it.toInt() }.toIntArray()
        array[1] = readln().split(" ").map { it.toInt() }.toIntArray()


    }
}