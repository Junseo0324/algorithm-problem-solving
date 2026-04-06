package programmers.practice04

fun main() {

}

fun solution134240(food: IntArray): String {
    var answer = ""
    var str = ""
    for (i in food.indices) {
        str += i.toString().repeat(food[i] / 2)
    }
    answer += str + "0" + str.reversed()
    return answer
}