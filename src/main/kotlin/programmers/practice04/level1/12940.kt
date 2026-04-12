package programmers.practice04.level1


fun solution12940(n: Int, m: Int): IntArray {
    var answer = intArrayOf()

    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun lcm(a: Int, b: Int): Int {
        return Math.abs(a*b) / gcd(a,b)
    }
    answer += gcd(n,m)
    answer += lcm(n,m)
    return answer
}