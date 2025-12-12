package BOJ.implementation

// https://www.acmicpc.net/problem/10431

/**
 * 아이들에게 키번호 부여. 키가 작은 애가 1번 ~ 가장 큰 애가 20번 / 같은 키는 없음
 * 아무나 한 명 뽑아 줄의 맨 앞에 세움. -> 그 다음부터 학생이 한 명씩 줄의 맨 뒤에 서면서
 * 자기 앞에 자기보다 큰 학생이 없다면 그냥 ㄱㄱ씽
 * 자기 앞에 있다면 그 앞에 선다.
 */
fun main() {
    val p = readln().toInt()
    repeat(p) {
        val array = mutableListOf<Int>()
        array += readln().split(" ").map { it.toInt() }.drop(1)

        var answer = 0
        for (i in 0 until 20) {
            for (j in 0 until i) {
                if (array[j] > array[i]) {
                    answer++
                }
            }
        }

        println("${it+1} $answer")
    }
}