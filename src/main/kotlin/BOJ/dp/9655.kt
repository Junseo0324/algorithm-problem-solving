package BOJ.dp

// https://www.acmicpc.net/problem/9655

/**
 * 돌 게임은 2명이서 게임
 * 돌 N개가 있을 때 턴을 번갈아가며 돌을 가져감. 1개 or 3개를 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 이기게 된다.
 * 이기는 사람을 구하는 프로그램 작성!
 * 게임은 상근이가 먼저 시작
 * 상근 = SK , 창영 = CY
 */
fun main() {
    val n = readln().toInt()
    println(if (n % 2 == 0) "SK" else "CY")
}