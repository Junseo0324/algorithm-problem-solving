package BOJ.dfs

/**
 * 컴퓨터 = 신뢰하는 관계 or 신뢰 x
        A -> B 를 신뢰하는 경우 B 해킹 시 A도 해킹 가능.
 * 첫째 줄에 N과 M
 * N <= 10,000 / M <= 100,000
 *
 */


fun main() {
    var (n,m) = readln().split(" ").map { it.toInt() }
    var list = Array(m) { mutableListOf<Int>() }
    var answer = mutableListOf<Int>()
    repeat(m) {
        var input = readln().split(" ").map { it.toInt() }
        list[input[0]].add(input[1])
    }


}