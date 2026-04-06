package programmers.practice04

fun main() {

}

fun solution12932(n: Long): IntArray {
    return n.toString().map { it.digitToInt() }.reversed().toIntArray()
}