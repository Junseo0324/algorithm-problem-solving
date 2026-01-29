package BOJ.simulation

import kotlin.math.abs

/**
 *  H, W (1 ≤ H, W ≤ 500)
 * 4 4
 * 3 0 1 4
 *
 * -> 5
 * answer = 0
 * 3 부터 시작해서 오른쪽을 봄.
 */
fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.toMutableList()

    var answer = 0

    for (i in 1 until w-1) {
        val left = list.subList(0,i).max()
        val right = list.subList(i+1,w).max()

        val smallerHeight = minOf(left,right)

        if (smallerHeight > list[i]) {
            answer += smallerHeight - list[i]
        }
    }

    println(answer)

}