package programmers.practice04

fun main() {
    println(intArrayOf(1, 5, 2, 6, 3, 7, 4).slice(0 until 7).toList().sorted()[2])
}
fun solution42748(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = intArrayOf()
    for (command in commands) {
        answer += command.slice(command[0]-1..command[1]-1).sorted()[command[2]-1]
    }
    return answer
}