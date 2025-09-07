package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/159994?language=kotlin

fun solution159994(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
    var card1_index = 0
    var card2_index = 0
    for (card in goal) {
        if (card == cards1[card1_index]) {
            if (card1_index < cards1.size-1) {
                card1_index++
            }
        } else if (card == cards2[card2_index]) {
            if (card2_index < cards2.size-1) {
                card2_index++
            }
        }else {
            return "No"
        }
    }
    return "Yes"
}

fun main() {
    println(solution159994(arrayOf("i", "water", "drink"), arrayOf("want", "to"), arrayOf("i", "want", "to", "drink", "water")))
}