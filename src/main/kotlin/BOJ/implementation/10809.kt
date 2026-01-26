package BOJ.implementation

fun main() {
    val s = readln().lowercase()
    val array = IntArray(26) { -1 }

    for (i in s.indices) {
        val char = s[i]

        if (array[char - 'a'] == -1) {
            array[char - 'a'] = i
        }
    }

    println(array.joinToString(" "))

}