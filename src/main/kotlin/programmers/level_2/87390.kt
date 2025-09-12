package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/87390

/**
 * n, left, right n행 n열로 만들기
 * -  ~ [i][i] = i 로 채우기
 * 그 다음에 행 별로 잘라서 붙이기. 그 후 newArr.slice(left,right) 리턴
 * 1<= n <=10^7  -> O(n)
 *
 */
fun solution87390(n: Int, left: Long, right: Long): IntArray {
    var answer = mutableListOf<Int>()
    for (i in left..right) {
        answer.add(maxOf((i%n).toInt()+1,(i/n).toInt()+1))
    }
    return answer.toIntArray()

}

fun main() {
    println(solution87390(3,2,5))
    println(solution87390(4,7,14))
}