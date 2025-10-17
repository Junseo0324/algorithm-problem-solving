package BOJ.hash

//https://www.acmicpc.net/problem/1920

fun main(){
    readln().toInt()
    val nSet= readln().split(" ").map { it.toInt() }.toSet()
    readln().toInt()
    val mArr = readln().split(" ").map { it.toInt() }

    mArr.forEach {
        if (nSet.contains(it)) {
            println(1)
        }else {
            println(0)
        }
    }
}