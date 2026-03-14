package BOJ.implementation

fun main() {
    val str = readln()
    val n = str.length

    var word = ""

    for (i in 1 until n - 1) {
        for (j in i + 1 until n) {
            val first = str.substring(0, i).reversed()
            val second = str.substring(i, j).reversed()
            val third = str.substring(j, n).reversed()

            val newWord = first + second + third

            if (word.isEmpty() || newWord < word) {
                word = newWord
            }
        }
    }
    println(word)
}