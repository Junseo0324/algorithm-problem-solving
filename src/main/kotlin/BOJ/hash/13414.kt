package BOJ.hash

fun main() {
    val (k,l) = readln().split(" ").map { it.toInt() }
    val hashMap = mutableMapOf<String,Int>()
    repeat(l) {
        hashMap[readln()] = it
    }
    println(hashMap.toList().sortedBy { it.second }.map { it.first }.take(k).joinToString("\n"))
}