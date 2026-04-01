package programmers.practice.dfs_bfs

fun main() {
    println(
        solution43163(begin = "hit", target = "cog", words = arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
    )
    println(
        solution43163(begin = "hit", target = "cog", words = arrayOf("hot", "dot", "dog", "lot", "log"))
    )
}

fun solution43163(begin: String, target: String, words: Array<String>): Int {
    var answer = 0
    val visited = BooleanArray(words.size)
    fun dfs(start: String,depth: Int) {
        if (start == target) {
            answer = depth
            return
        }

        for (i in words.indices) {
            if (isChange(start,words[i]) && !visited[i]) {
                visited[i] = true
                dfs(words[i],depth+1)
                visited[i] = false
            }
        }

    }
    dfs(begin,0)
    return answer
}

fun isChange(word1: String, word2: String): Boolean {
    var count = 0
    for (i in word1.indices) {
        if (word1[i] != word2[i]) {
            count++
            if (count > 1) return false
        }
    }
    return count == 1
}