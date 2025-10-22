package BOJ.deque

// https://www.acmicpc.net/problem/5430
/**
 * AC 언어 -> 정수 배열에 연산을 하기 위한 언어
 * 함수 -> R(뒤집기) , D(버리기) 존재
 * R -> 배열에 있는 수의 순서를 뒤집는 함수
 * D -> 첫 번째 수를 버리는 함수
 * 배열이 비어있는데 D를 사용하면 error
 *
 */

fun main() {
    val T = readln().toInt()
    val answer = mutableListOf<String>()
    repeat(T) {
        val p = readln()
        val n = readln().toInt()
        val data = readln().removeSurrounding("[","]")
        val deque = ArrayDeque<String>()
        if (data.isNotEmpty()) {
            deque.addAll(data.split(","))
        }
        var removeIdx = true
        var isError = false
        for (c in p) {
            if (c == 'R') {
                removeIdx = !removeIdx
            } else {
                if (deque.isEmpty()) {
                    isError = true
                    break
                }
                if (removeIdx) {
                    deque.removeFirst()
                } else {
                    deque.removeLast()
                }
            }
        }
        if (isError) {
            answer.add("error")
        }else {
            if (removeIdx) {
                answer.add(deque.joinToString(",", "[", "]"))
            } else {
                answer.add(deque.asReversed().joinToString(",", "[", "]"))
            }
        }
    }
    println(answer.joinToString("\n"))
}