package BOJ.implementation

// https://www.acmicpc.net/problem/5073

// Equilateral 3 똑
// Isosceles 2개만 같을 때
// Scalene 다 다를때
// Invalid
fun main() {
    while (true) {
        var input = readln().split(" ").sorted().map { it.toInt() }
        if (input.all { it == 0 }) break

        input = input.sorted()

        val a = input[0]
        val b = input[1]
        val c = input[2]

        if (c >= a + b) {
            println("Invalid")
        } else if (a == b && b == c) {
            println("Equilateral")
        } else if (a == b || b == c) {
            println("Isosceles")
        } else {
            println("Scalene")
        }
    }
}