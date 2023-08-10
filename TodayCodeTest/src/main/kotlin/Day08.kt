fun main(args: Array<String>) {
    println("Solution 01")
    println(solution01(2, 2, 2, 2))
    println(solution01(4, 1, 4, 4))
    println(solution01(6, 3, 3, 6))
    println(solution01(2, 5, 2, 6))
    println(solution01(6, 4, 2, 5))

    println()
    println("Solution 02")
    println(solution02("123"))
    println(solution02("78720646226947352489"))

    println()
    println("Solution 03")
    println(solution03("rermgorpsam", arrayOf(intArrayOf(2, 3), intArrayOf(0, 7), intArrayOf(5, 9), intArrayOf(6, 10))))
}

/***
 * 1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.
 * 네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
 * 세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
 * 주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
 * 어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
 * 네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
 * 네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
 */
fun solution01(a: Int, b: Int, c: Int, d: Int): Int {
    val dice: Map<Int, Int> = arrayOf(a, b, c, d).groupingBy { it }.eachCount()

    return when {
        dice.values.any { it == 4 } -> {
            val p = dice.filterValues { it == 4 }.keys.first()
            1111 * p
        }

        dice.values.any { it == 3 } -> {
            val (p, q) = arrayOf(
                dice.filterValues { it == 3 }.keys.first(),
                dice.filterValues { it == 1 }.keys.first(),
            )
            (10 * p + q) * (10 * p + q)
        }

        dice.values.all { it == 2 } -> {
            val (p, q) = dice.filterValues { it == 2 }.keys.toIntArray()
            (p + q) * kotlin.math.abs(p - q)
        }

        dice.values.any { it == 2 } -> {
            val (q, r) = dice.filterValues { it == 1 }.keys.toIntArray()
            q * r
        }

        else -> dice.keys.minOrNull() ?: -1
    }

}

/***
 * 음이 아닌 정수를 9로 나눈 나머지는 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지와 같은 것이 알려져 있습니다.
 * 이 사실을 이용하여 음이 아닌 정수가 문자열 number로 주어질 때, 이 정수를 9로 나눈 나머지를 return 하는 solution 함수를 작성해주세요.
 */
fun solution02(number: String): Int {
    return number.sumOf { it.digitToInt() } % 9
}

/**
 * 문제 설명
 * 문자열 my_string과 이차원 정수 배열 queries가 매개변수로 주어집니다. queries의 원소는 [s, e] 형태로, my_string의
 * 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다. my_string에 queries의 명령을 순서대로 처리한 후의 문자열을 return 하는
 * solution 함수를 작성해 주세요.
 *
 * 제한사항
 * my_string은 영소문자로만 이루어져 있습니다.
 * 1 ≤ my_string의 길이 ≤ 1,000
 * queries의 원소는 [s, e]의 형태로 0 ≤ s ≤ e < my_string의 길이를 만족합니다.
 * 1 ≤ queries의 길이 ≤ 1,000
 */
fun solution03(my_string: String, queries: Array<IntArray>): String {
    var newString: String = my_string

    queries.forEach { (start, end) ->
        val prefix = newString.substring(0, start)
        val reversedString = newString.substring(start, end + 1).reversed()
        val suffix = newString.substring(end + 1)

        newString = prefix + reversedString + suffix
    }

    return newString
}