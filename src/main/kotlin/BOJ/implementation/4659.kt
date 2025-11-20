package BOJ.implementation

// https://www.acmicpc.net/problem/4659

fun main() {
    while (true) {
        val str = readln()
        if (str == "end") break
        var vowelCount = 0
        var consonantCount = 0
        val vowel = listOf('a','e','i','o','u')
        var isAccept = true
        var hasVowel = false
        for (i in str.indices) {
            val isV = str[i] in vowel

            if (isV) hasVowel = true

            if (isV) {
                vowelCount++
                consonantCount = 0
            } else {
                vowelCount = 0
                consonantCount++
            }

            if (vowelCount == 3 || consonantCount == 3) {
                isAccept = false
                break
            }

            if (i >0 && str[i-1] == str[i]) {
                if (str[i] != 'e' && str[i] != 'o') {
                    isAccept = false
                    break
                }
            }

        }
        if (!hasVowel) isAccept = false

        if (isAccept) {
            println("<$str> is acceptable.")
        } else {
            println("<$str> is not acceptable.")
        }
    }
}