package BOJ.trytty

fun main() {
    val k = readln().toInt()
    val signs = readln().split(" ")

    val result = mutableListOf<String>()
    val visited = BooleanArray(10)

    fun backtrack(current: String, depth: Int) {
        if (depth == k + 1) {
            result.add(current)
            return
        }

        for (i in 0..9) {
            if (!visited[i]) {
                if (depth == 0 || signPossible(current.last() - '0', i, signs[depth - 1])) {
                    visited[i] = true
                    backtrack(current + i.toString(),depth + 1)
                    visited[i] = false
                }
            }
        }
    }

    backtrack("", 0)

    println(result.last())
    println(result.first())

}

fun signPossible(first: Int, second: Int, sign: String): Boolean {
    return if (sign == "<") first < second else first > second
}