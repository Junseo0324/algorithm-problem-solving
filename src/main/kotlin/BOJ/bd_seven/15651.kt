package BOJ.bd_seven

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val bw = System.out.bufferedWriter()
    val result = mutableListOf<Int>()

    fun backtrack(depth: Int) {
        if (depth == m) {
            bw.write(result.joinToString(" ")+"\n")
            return
        }

        for (i in 1..n) {
            result.add(i)
            backtrack(depth+1)
            result.removeLast()
        }
    }

    backtrack(0)

    bw.flush()


}

fun combintation(list: List<Int>,k:Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun backtrack(current: MutableList<Int>) {
        if (current.size == k) {
            result.add(current.toList())
            return
        }

        for (i in list.indices) {
            current.add(list[i])

            backtrack(current)

            current.removeAt(current.size-1)
        }
    }

    backtrack(mutableListOf())
    return result
}