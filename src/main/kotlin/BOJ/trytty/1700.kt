package BOJ.trytty

/**
 * 2 7
 * 2 3 2 3 1 2 7
 * ------------------------
 * 3 6
 * 1 2 3 4 1 2
 * ------------------------
 *
 * hashMap = 우선순위 -> 자주쓰는거? 근데 예를 들어 2를 다썼는데 2를 가지고 있는다? 말이 안되는거 아닌가. 흠.
 *
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }

    val hashMap = mutableMapOf<Int, Int>()
    for (data in list) {
        hashMap[data] = hashMap.getOrDefault(data, 0) + 1
    }

    println(hashMap)

    var answer = 0

    val usedArray = mutableListOf<Int>()

    for (i in list.indices) {
        if (usedArray.size < n) { // 콘센트가 남았을 경우
            usedArray.add(list[i])
        } else if (usedArray.size == n) { // 콘센트가 다 쓰는 중
            if (list[i] !in usedArray) { // 만약 다음 것이 현재 리스트에 없다면

            }
        }
    }
}