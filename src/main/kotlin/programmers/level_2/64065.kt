package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/64065

/**
 * n-tuple : n개의 요소를 가진 튜플,,
 * 중복된 원소가 있을 수 있다.
 * 원소에 정해진 순서가 있으며, 순서가 다르면 다른 튜플 (1,2,3) != (1,3,2)
 * 튜플 원소의 개수는 유한하다.
 * 원소의 개수가 n 이고 중복되는 원소가 없는 튜플이 주어질 때, 이는 집합 기호를 이용해 표현 가능
 */
fun solution64065(s: String): IntArray {
    var answer = intArrayOf()
    var list = s.removeSurrounding("{{","}}").split("},{").map { it.split(",").map { it.toInt() } }
    list = list.sortedBy { it.size }
    for (i in list.indices) {
        answer += list[i].filter { it !in answer }.first()
    }
    println(answer.joinToString(","))
    return answer
}

fun main() {
    println(solution64065("{{2},{2,1},{2,1,3},{2,1,3,4}}"))
    println(solution64065("{{1,2,3},{2,1},{1,2,4,3},{2}}"))
    println(solution64065("{{20,111},{111}}"))
    println(solution64065("{{123}}"))
    println(solution64065("{{4,2,3},{3},{2,3,4,1},{2,3}}"))
}