package programmers.practice.greedy

fun main() {
    println(solution42883(number = "1924", k = 2))
    println(solution42883(number = "1231234", k = 3))
    println(solution42883(number = "4177252841", k = 4))
}

fun solution42883(number: String, k: Int): String {
    val stack = ArrayDeque<Char>()
    var count = k

    for (num in number) {
        while (stack.isNotEmpty() && count > 0 && stack.last() < num) {
            stack.removeLast()
            count--
        }
        stack.addLast(num)
    }
    return stack.take(number.length - k).joinToString("")
}