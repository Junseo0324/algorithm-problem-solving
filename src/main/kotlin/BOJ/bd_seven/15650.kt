package BOJ.bd_seven

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()

    fun backtrack(start:Int, depth: Int) {
        if (depth == m) {
            println(result.joinToString(" "))
            return
        }

        for (i in start..n) {
            result.add(i)
            backtrack(i+1,depth+1)
            result.removeLast()
        }
    }
    backtrack(1,0)


}