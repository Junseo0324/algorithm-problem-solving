package BOJ.implementation

// https://www.acmicpc.net/problem/1427

fun main() = println(readln().toCharArray().sortedByDescending { it.digitToInt() }.joinToString(""))