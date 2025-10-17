package BOJ.hash

// https://www.acmicpc.net/problem/1269

/**
 * 두 집합의 대칭 차집합의 원소의 개수 출력
 * (a-b) (b-a)의 합집합을 A와 B의 대칭 차집합
 *
 * ex)  A={1,2,4}, B = {2,3,4,5,6} 라고 할 때, A-B = {1} 이고, B-A = {3,5,6} 이므로, 대칭 차집합의 원소의 개수는 1+3=4
 * 공통된거를 한번에 구한다? 그리고 a.size - x + b.size - x = answer
 * 2x10^5
 */
fun main() {
    readln().split(" ").map { it.toInt() }
    val aSet = readln().split(" ").map { it.toInt() }.toSet()
    val bSet = readln().split(" ").map { it.toInt() }.toSet()

    val amb = aSet.subtract(bSet)
    val bma = bSet.subtract(aSet)
    println(amb.size + bma.size)

}