package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/42748

fun solution42748(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = intArrayOf()

    for (command in commands) {
        answer +=
            array.slice(command[0]-1 until command[1]).sorted()[command[2]-1]
    }
    return answer
}

fun main() {
    println(solution42748(
        intArrayOf(1, 5, 2, 6, 3, 7, 4),
        arrayOf(
            intArrayOf(2,5,3),
            intArrayOf(4,4,1),
            intArrayOf(1,7,3)
        )
    ))
}