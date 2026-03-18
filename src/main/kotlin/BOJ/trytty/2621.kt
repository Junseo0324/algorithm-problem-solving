package BOJ.trytty

fun main() {
    val list = mutableListOf<Pair<String,Int>>()
    val hashMap = mutableMapOf<String,Int>()
    val numList = mutableListOf<Int>()
    repeat(5) {
        val (a,b) = readln().split(" ")
        list.add(a to b.toInt())
        hashMap[a] = hashMap.getOrDefault(a,0)+1
        numList.add(b.toInt())
    }
    val numberMap =numList.groupingBy { it }.eachCount()

    var answer = 0


    // 카드 5장이 모두 같은 색 & 숫자가 연속적이라면
    if (hashMap.size == 1 && isContinuous(numList)) {
        answer = 900 + numList.max()
    } else if (numberMap.maxBy { it.value }.value == 4) { // 4장의 숫자가 같을 경우
        answer = 800 + numberMap.maxBy { it.value }.key
    } else if (numberMap.maxBy { it.value }.value == 3 && numberMap.size == 2) { // 3 & 2 일 경우
        answer = 700 + (numberMap.maxBy { it.value }.key * 10) + numberMap.minBy { it.value }.key
    } else if (hashMap.size == 1) { // 5장의 카드 색깔이 모두 같을 때
        answer = 600 + numList.max()
    } else if (isContinuous(numList)) { // 카드 5장의 숫자가 연속적일 때
        answer = 500 + numList.max()
    } else if (numberMap.maxBy { it.value }.value == 3 && numberMap.size == 3) { // 카드 5장 중 3장의 숫자가 같을 때
        answer = 400 + numberMap.maxBy { it.value }.key
    } else if (numberMap.values.count { it==2 } == 2) {
        val numbers = numberMap.filter { it.value == 2 }.keys.sorted()
        answer = (numbers[1] * 10) + numbers[0]+ 300
    } else if (numberMap.filter { it.value ==2 }.count() ==1) {
        answer = 200 + numberMap.maxBy { it.value }.key
    } else {
        answer = 100 + numList.max()
    }

    println(answer)

}

fun isContinuous(list: MutableList<Int>): Boolean {
    val sortedList = list.sorted()
    for (i in 0 until sortedList.size-1) {
        if (sortedList[i+1] - sortedList[i] != 1) {
            return false
        }
    }
    return true
}