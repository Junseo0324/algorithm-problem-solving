package BOJ.implementation

// https://www.acmicpc.net/problem/2941
/**
 * 크로아티아 알파벳
 * č	c=
 * ć	c-
 * dž	dz=
 * đ	d-
 * lj	lj
 * nj	nj
 * š	s=
 * ž	z=
 */
fun main() {
    val word = readln().replace("c=","1").replace("c-","2").replace("dz=","3")
        .replace("d-","4").replace("lj","5").replace("nj","6")
        .replace("s=","7").replace("z=","8")

    println(word.length)
}