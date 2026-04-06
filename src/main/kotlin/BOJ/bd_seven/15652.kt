package BOJ.bd_seven

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    val result = mutableListOf<Int>()

    fun backtrack(depth: Int) {
        if (depth == m) {
            sb.append(result.joinToString(" ")).append("\n")
            return
        }

        for (i in 1..n) {
            result.add(i)
            backtrack(depth+1)
            result.removeLast()
        }
    }

    backtrack(0)

    println(sb.toString())

}
