package programmers.practice.hash

fun main() {
    println(
        solution42579(
            genres = arrayOf(
                "classic", "pop", "classic", "classic", "pop"
            ),
            plays = intArrayOf(
                500, 600, 150, 800, 2500
            )
        )
    )
}

fun solution42579(genres: Array<String>, plays: IntArray): MutableList<Int> {
    val genreHashMap = mutableMapOf<String, Int>()
    for (i in genres.indices) {
        genreHashMap[genres[i]] = genreHashMap.getOrDefault(genres[i], 0) + plays[i]
    }

    val sortedGenres = genreHashMap.toList()
        .sortedByDescending { it.second }.map { it.first }

    val answer = mutableListOf<Int>()
    for (genre in sortedGenres) {
        val songs = genres.indices
            .asSequence()
            .filter { genres[it] == genre }
            .map { it to plays[it] }
            .sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first })
            .take(2).toMutableList()

        songs.forEach {
            answer.add(it.first)
        }
    }

    return answer
}