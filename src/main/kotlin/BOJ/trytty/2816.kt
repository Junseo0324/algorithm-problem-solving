package BOJ.trytty

/**
 * kbs1 ->1 , kbs2 -> 2
 * 1. 화살표를 한칸 아래
 * 2.화살표를 위로 한캌ㄴ
 * 3.현재 선택한채널을 한칸 아래.
 * 4.현재 선택한 채널을 위로
 */
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<String>()
    val answer = mutableListOf<Int>()
    repeat(n) {
        list.add(readln())
    }

    val kbs1_index = list.indexOf("KBS1")
    val kbs2_index = list.indexOf("KBS2")

    repeat(kbs1_index) {
        answer.add(1)
    }

    repeat(kbs1_index) {
        answer.add(4)
    }

    if (kbs2_index < kbs1_index) {
        repeat(kbs2_index + 1) {
            answer.add(1)
        }
        repeat(kbs2_index) {
            answer.add(4)
        }
    } else {
        repeat(kbs2_index) {
            answer.add(1)
        }
        repeat(kbs2_index-1) {
            answer.add(4)
        }
    }

    println(answer.joinToString(""))
}