package BOJ.trytty

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(4) }
    repeat(n) {
        array[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val target = array.find { it[0] == k }!!

    var answer = 0
    for (country in array) {
        if (country[1] > target[1]) {
            answer++
        } else if (country[1] == target[1] && country[2] > target[2]) {
            answer++
        } else if (country[1] == target[1] && country[2] == target[2] && country[3] > target[3]) {
            answer++
        }
    }

    println(answer + 1)

}

data class Country(
    val id: Int,
    val gold: Int,
    val sliver: Int,
    val bronze: Int
)

fun main2() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Country>()

    repeat(n) {
        val data = readln().split(" ").map { it.toInt() }
        list.add(Country(data[0],data[1],data[2],data[3]))
    }

    val target = list.find { it.id == k }!!
    var count = 0

    for (country in list) {
        if (country.gold > target.gold) {
            count++
        } else if (country.gold == target.gold && country.sliver > target.sliver) {
            count++
        } else if (country.gold == target.gold && country.sliver == target.sliver && country.bronze > target.bronze) {
            count++
        }
    }

    println(count+1)
}