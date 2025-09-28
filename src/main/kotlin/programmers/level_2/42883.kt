package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/42883

/**
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 수를 구하려 함
 * 1924 -> 2개를 제거, -> 19,12,14,92,94,24
 * 2<= number.length <= 10^6
 *
 * 1 을 먼저 넣고 9 가 들어오면 2개 삭제 가능. 1 삭제, 92 ....
 */

fun solution42883(number: String, k: Int): String {
    val list = mutableListOf<Char>()
    var count = k

    for (c in number) {
        val curr = c
        while (list.isNotEmpty() && list.last() < curr && count > 0) {
            list.removeAt(list.size -1)
            count--
        }
        list.add(curr)
    }

    return list.take(list.size - count).joinToString("")
}

fun main() {
    println(solution42883("1924",2))
    println(solution42883("1231234",3))
    println(solution42883("4177252841",4))
}