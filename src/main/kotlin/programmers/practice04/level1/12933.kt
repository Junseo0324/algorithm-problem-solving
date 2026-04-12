package programmers.practice04.level1

fun main() {

}

fun solution12933(n: Long): Long {
    return n.toString().map { it.digitToInt() }.sortedDescending().joinToString("").toLong()
}