package BOJ.graph

// https://www.acmicpc.net/problem/5427

/**
 * '.': 빈 공간 =  0
 * '#': 벽 = -1
 * '@': 상근이의 시작 위치 = 1
 * '*': 불 = 2
 *
 * 불은 인접한 빈 공간으로 퍼져나간다. 벽에는 불이 붙지 않음.
 * 상근이는 인접한 칸 이동 가능 1초가 걸림. 불이 옮겨진 칸 or 불이 붙으려는 칸으로 이동 x
 */

fun main() {
    repeat(readln().toInt()) {
        val (w, h) = readln().split(" ").map { it.toInt() }

    }
}