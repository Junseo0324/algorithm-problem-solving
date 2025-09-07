package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12915?language=kotlin

/**
 * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하기
 * ex) sun bed car .. n = 1 , u e a 기준으로 정렬.
 */
fun solution12915(strings: Array<String>, n: Int): Array<String> {
    var answer = strings.sortedWith(compareBy({it[n]},{it}))
    println(answer)
    return answer.toTypedArray()
}

fun main() {
    println(solution12915(arrayOf("abce", "abcd", "cdx"),2))
}