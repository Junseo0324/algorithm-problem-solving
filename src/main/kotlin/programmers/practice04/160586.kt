package programmers.practice04

fun main() {
    println(solution160586(
        keymap = arrayOf("ABACD", "BCEFD"),
        targets = arrayOf("ABCD","AABB")
    ))
    println(solution160586(
        keymap = arrayOf("AA"),
        targets = arrayOf("B")
    ))
    println(solution160586(
        keymap = arrayOf("AGZ","BSSS"),
        targets = arrayOf("ASA","BGZ")
    ))
}

fun solution160586(keymap: Array<String>, targets: Array<String>): IntArray {
    val answer: IntArray = intArrayOf()

    for (target in targets) {
        for (word in target) {

        }
    }
    return answer
}