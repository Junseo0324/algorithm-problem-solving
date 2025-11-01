package BOJ.simulation

/**
 *  + - x / 순서의 배열값 ..
 */

fun main() {
    val n = readln().toInt()
    val array = readln().split(" ").map { it.toInt() }
    val ops = readln().split(" ").map { it.toInt() }.toMutableList()
    val answer = mutableListOf<Long>()

    fun dfs(depth: Int, curr: Int) {
        if (depth == n) {
            answer.add(curr.toLong())
        }

        for (i in 0 until 4) {
            if (ops[i] > 0) {
                ops[i]--
                val next = when(i) {
                    0 -> curr + array[depth]
                    1 -> curr - array[depth]
                    2 -> curr * array[depth]
                    3 -> curr / array[depth]
                    else -> curr
                }
                dfs(depth+1,next)
                ops[i]++
            }
        }
    }

    dfs(1,array[0])

    println(answer.maxOf { it })
    println(answer.minOf { it })

}