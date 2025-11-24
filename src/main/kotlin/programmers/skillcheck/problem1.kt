package programmers.skillcheck

/**
 * 1. 한번에 한 개의 알파벳만 바꿀 수 있다.
 * 2. words 에 있는 단어로만 변환할 수 있다.
 * hit -> hot -> dot -> dog -> cog
 *
 * 각 단어의 길이는 3~10 / 3< words.size < 50
 * 50 x 50 x 10 = 2500 ?
 */
fun solution1(begin: String, target: String, words: Array<String>): Int {
    val visited = BooleanArray(words.size)

    val queue = ArrayDeque<Pair<String,Int>>()
    queue.add(begin to 0)

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()

        if (curr.first == target) {
            return curr.second
        }

        for ((idx,word) in words.withIndex()) {
            if (!visited[idx] && canChange(curr.first, word)) {
                visited[idx] = true
                queue.add(word to curr.second+1)
            }
        }
    }

    return 0
}


fun canChange(word1: String, word2: String): Boolean {
    return word1.indices.count { word1[it] != word2[it] } == 1
}


fun main() {
    println(
        solution1("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
    )
    println(
        solution1("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log"))
    )
}

