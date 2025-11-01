package BOJ.implementation

import kotlin.math.round

// https://www.acmicpc.net/problem/2108

/**
 * 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
 */
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    repeat(n) {
        list.add(readln().toInt())
    }
    println(round(list.sum().toDouble() / n).toInt())
    println(list.sorted()[list.size / 2])
    val hashMap = mutableMapOf<Int, Int>()
    list.forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
    }
    val maxValue = hashMap.values.max()
    val valueList = hashMap.filterValues { it == maxValue }.keys.sorted()
    println(if (valueList.size == 1) valueList[0] else valueList[1])
    println(list.max() - list.min())
}