package BOJ.implementation

/**
 * AABB -> ABBA
 * AAABB -> ABABA
 * ABACABA -> AABCBAA
 */
fun main() {
    val str = readln()

    val array = IntArray(26)

    for (c in str) {
        array[c - 'A']++
    }

    var oddCount = 0
    var centerChar = ""
    val halfResult = mutableListOf<Char>()

    for (i in 0 until 26) {
        val char = (i + 'A'.toInt()).toChar()
        if (array[i] % 2 != 0) {
            oddCount++
            centerChar = char.toString()
        }

        repeat(array[i] / 2) {
            halfResult.add(char)
        }
    }

    if (oddCount > 1) {
        println("I'm Sorry Hansoo")
    } else {
        val first = halfResult.joinToString("")
        val last = halfResult.joinToString("").reversed()
        println(first + centerChar + last)
    }
}