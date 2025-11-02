package BOJ.implementation

// https://www.acmicpc.net/problem/1244

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    val array = readLine().split(" ").map { it.toInt() }.toMutableList()
    val student = readLine().toInt()

    repeat(student) {
        val (gender, number) = readLine().split(" ").map { it.toInt() }

        if (gender == 1) { // 남학생
            for (i in number..n step number) {
                array[i - 1] = 1 - array[i - 1]
            }
        } else { // 여학생
            val idx = number - 1
            var left = idx
            var right = idx

            while (left > 0 && right < n - 1 && array[left - 1] == array[right + 1]) {
                left--
                right++
            }

            for (i in left..right) {
                array[i] = 1 - array[i]
            }
        }
    }

    for (i in array.indices) {
        sb.append(array[i]).append(' ')
        if ((i + 1) % 20 == 0) sb.append('\n')
    }

    println(sb)
}