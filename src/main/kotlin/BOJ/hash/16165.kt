package BOJ.hash

// https://www.acmicpc.net/problem/16165

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val hashMap = mutableMapOf<String,String>()
    repeat(n){
        val name = readln()
        val member = readln().toInt()
        repeat(member) {
            hashMap[readln()] = name
        }
    }
    repeat(m) {
        val quest = readln()
        if (readln().toInt() == 1) {
            val answer = hashMap[quest]
            println(answer)
        } else {
            val arr = mutableListOf<String>()
            hashMap.forEach { (k,v) ->
                if (v == quest) {
                    arr.add(k)
                }
            }
            println(arr.sorted().joinToString("\n"))
        }
    }
}