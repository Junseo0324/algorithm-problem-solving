package stack_queue

import java.util.Stack

/**오큰수
 3,5,2,7 -> 5,7,7,-1
 마지막 수는 항상 -1 -> if (index == list.size-1) ngeList.add(-1)
 stack.add(3) 첫 번째 수를 넣었다고 가정
    이 수를 stack.peek() = curr에 지정 후 다음 수 입력
    if (curr < stack.peek()) ->

 다시...
 array = 3,5,2,7 에서 stack에 하나씩 넣음.
for(i in array.indices) {
 if stack.isNotEmpty() {


*/
fun main() {
    var n = readln().toInt()
    var array = readln().split(" ").map { it.toInt() }.reversed()

    var ngeList = mutableListOf<Int>()
    var stack = Stack<Int>()
    //array -> 7,2,5,3
    //stack -> 7 ,5,3
    //ngeList -> -1 ,7,7,5
    ngeList.add(-1)
    stack.push(array[0])
    for (i in 1 until array.size) {
        while (true) {
            if (stack.isEmpty()) {
                stack.push(array[i])
                ngeList.add(-1)
                break
            } else {
                var curr = stack.peek()
                if (curr <= array[i]) {
                    stack.pop()
                } else {
                    ngeList.add(curr)
                    stack.push(array[i])
                    break
                }
            }
        }
    }
    println(ngeList.reversed().joinToString(" "))


}