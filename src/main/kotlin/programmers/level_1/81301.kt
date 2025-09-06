package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=kotlin

fun solution(s: String): Int {
    var answer = s
    var wordArr = arrayOf(
        "zero","one","two","three","four","five","six","seven","eight","nine"
    )
    for (i in wordArr.indices) {
        if (answer.contains(wordArr[i])) {
            answer = answer.replace(wordArr[i],i.toString())
        }
    }
    return answer.toInt()
}

fun main() {
    println(solution("one4seveneight"))
}