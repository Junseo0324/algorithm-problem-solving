package programmers.practice04.level1

fun main() {
    println(
        solution159994(
            cards1 = arrayOf("i", "drink", "water"),
            cards2 = arrayOf("want", "to"),
            goal = arrayOf("i", "want", "to", "drink", "water")
        )
    )
    println(
        solution159994(
            cards1 = arrayOf("i", "water", "drink"),
            cards2 = arrayOf("want", "to"),
            goal = arrayOf("i", "want", "to", "drink", "water")
        )
    )
}

fun solution159994(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
    var idx1 = 0
    var idx2 = 0

    for (word in goal) {
        if (idx1 < cards1.size && word == cards1[idx1]) {
            idx1++
        } else if (idx2 < cards2.size && word == cards2[idx2]) {
            idx2++
        } else {
            return "No"
        }
    }
    return "Yes"
}