package BOJ.implementation

/**
 * 고유 번호 부여. 학생 번호는 0~9 사이 숫자로 이루어진 문자열.
 * 뒤자리 k만 남겨놓았을 때
 */
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<String>()
    repeat(n) {
        list.add(readln())
    }

    val size = list.first().length
    for (i in 1..size) {
        val temp = list.map { it.substring(size - i, size) }
        if (temp.toSet().size == n) {
            println(i)
            return
        }
    }
}