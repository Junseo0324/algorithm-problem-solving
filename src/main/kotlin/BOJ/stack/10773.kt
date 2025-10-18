package BOJ.stack

// https://www.acmicpc.net/problem/10773

fun main() {
    val stack = mutableListOf<Int>()
    val k = readln().toInt()
    repeat(k) {
        val number = readln().toInt()
        if (number == 0) {
            stack.removeLast()
        } else {
            stack.add(number)
        }
    }
    println(stack.sum())
}