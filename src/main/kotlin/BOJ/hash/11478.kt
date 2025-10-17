package BOJ.hash

// https://www.acmicpc.net/problem/11478

fun main() {
    val str = readln()
    val set = mutableSetOf<String>()
    for (i in 0 until str.length) {
        for (j in i until str.length) {
            set.add(str.substring(i,j+1))
        }
    }
    println(set.size)
}