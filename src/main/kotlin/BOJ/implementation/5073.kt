package BOJ.implementation

// https://www.acmicpc.net/problem/5073

// Equilateral 3 똑
// Isosceles 2개만 같을 때
// Scalene 다 다를때
// Invalid
fun main() {
    val list = mutableListOf<String>()
    while (true) {
        val input = readln().split(" ").sorted().map { it.toInt() }
        if (input.all { it == 0 }) break
        val a = input[0]
        val b = input[1]
        val c = input[2]

        if (c >= a+b) {
            list.add("Invalid")
            continue
        }
        if (c == a && c == b) {
            list.add("Equilateral")
            continue
        }
        var count = 0
        for (i in 0 until 3) {
            if (input[0] == input[1]) count++
        }

    }

}