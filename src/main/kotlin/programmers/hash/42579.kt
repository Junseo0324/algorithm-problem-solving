package programmers.hash

// https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=kotlin

/**
 * 속한 노래가 가장 많이 재생된 장르를 먼저 수록
 * 장르 내에서 많이 재생된 노래를 먼저 수록한다
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * genres = 노래의 장르를 나타냄
 * plays = 노래별 재생 횟수를 나타내는 정수
 */

fun solution42579(genres: Array<String>, plays: IntArray): IntArray {
    val genreMap = hashMapOf<String,Int>()
    val playsWithIndex = mutableListOf<Pair<Int,Int>>()
    for (i in plays.indices) {
        playsWithIndex.add(Pair(i,plays[i]))
    }
    val zip = genres.zip(playsWithIndex.toTypedArray()).sortedByDescending { it.second.second }
    for (i in genres.indices) {
        genreMap[genres[i]] = genreMap.getOrDefault(genres[i],0)+plays[i]
    }
    val genreSorted = genreMap.toList().sortedByDescending { it.second }.toMap().toMutableMap()
    val hashMap = mutableMapOf<String,MutableList<Int>>()

    for ((g,_) in genreSorted) {
        val list = mutableListOf<Int>()
        for ((k,v) in zip) {
            if (k == g) {
                if (list.size == 2) {
                    break
                }
                list.add(v.first)
                hashMap[g] = list
            }
        }
    }
    return hashMap.flatMap { it.value }.toIntArray()
}


fun main() {
    println(
        solution42579(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500))
    )
}