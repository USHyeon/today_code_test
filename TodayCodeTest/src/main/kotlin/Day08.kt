fun main(args: Array<String>) {
    println("Solution 01")
    println(solution01(2, 2, 2, 2))
    println(solution01(4, 1, 4, 4))
    println(solution01(6, 3, 3, 6))
    println(solution01(2, 5, 2, 6))
    println(solution01(6, 4, 2, 5))


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