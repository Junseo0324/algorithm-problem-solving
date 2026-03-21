package BOJ.trytty


/**
 * 최소 한 개 모음 + 최소 2개의 자음으로 구성
 * 경우의 수를 만들어? 3< l <15
 *
 * 모든 데이터를 만든 뒤 이 중에 모음이 1개 이상인지 체크하기.
 */
fun main() {
    val (l, c) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").sorted()

    val vowelList = listOf('a', 'e', 'i', 'o', 'u')

    val allList = combinations(list, l)


    val answer = mutableListOf<String>()
    for (word in allList) {
        val vowelCount = word.count { it in vowelList }
        val consonantCount = l - vowelCount

        if (vowelCount >= 1 && consonantCount >= 2) {
            answer.add(word)
        }
    }

    println(answer.sorted().joinToString("\n"))
}


fun combinations(list: List<String>, k: Int): List<String> {
    val result = mutableListOf<String>()

    fun backtrack(start: Int, current: MutableList<String>) {
        if (current.size == k) {
            result.add(current.joinToString(""))
            return
        }

        for (i in start until list.size) {
            current.add(list[i])

            backtrack(i + 1, current)

            current.removeAt(current.size - 1)
        }
    }

    backtrack(0, mutableListOf())
    return result
}