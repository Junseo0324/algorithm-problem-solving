package programmers.level_1

import java.util.Stack

// https://school.programmers.co.kr/learn/courses/30/lessons/133502

/**
 * 빵 - 야채 - 고기 - 빵 // 1-2-3-1
 *
 * stack - 2,1,1,2,3,1
 */
fun solution133502(ingredient: IntArray): Int {
    var answer= 0
//
//    while (true) {
//        if (!listWord.contains(keyword)) {
//            break
//        }
//        for (i in 0 until listWord.length-3) {
//            if (listWord[i] == keyword[0]) {
//                if (listWord.substring(i..i+3) == keyword) {
//                    listWord = listWord.replaceFirst(keyword,"")
//                    answer++
//                    break
//                }
//            }
//        }
//    }

    var stack = Stack<Int>()
    for (i in ingredient.indices) {
        stack.add(ingredient[i])
        if (stack.size >=4 && stack.takeLast(4) == listOf(1,2,3,1)) {
            repeat(4) {
                stack.removeLast()
            }
            answer++
        }
    }
    return answer
}

fun main() {
    println(solution133502(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)))
    println(solution133502(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)))
}