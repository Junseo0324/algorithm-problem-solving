package programmers.practice.sort


fun main() {
    println(
        solution42748(
            array = intArrayOf(1, 5, 2, 6, 3, 7, 4),
            commands = arrayOf(
                intArrayOf(2, 5, 3),
                intArrayOf(4, 4, 1),
                intArrayOf(1, 7, 3),
            )
        )
    )
}

fun solution42748(array: IntArray, commands: Array<IntArray>): MutableList<Int> {
    val answer = mutableListOf<Int>()
    for (command in commands) {
        answer += array.slice(command[0]-1 .. command[1]-1).sorted()[command[2]-1]
    }
    return answer
}