package programmers.practice04

fun main() {

}

fun solution81301(s: String): Int {
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