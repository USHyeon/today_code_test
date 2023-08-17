package algorithm

import kotlin.math.max
import kotlin.math.min

// 완전탐색
fun main(args: Array<String>) {
    /**
     * solution01 : 최소직사각형
     * 문제 설명
     * 명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서,
     * 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
     * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
     * 명함 번호	가로 길이	세로 길이
     * 1	    60	    50
     * 2	    30	    70
     * 3	    60	    30
     * 4	    80	    40
     * 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
     * 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다.
     * 이때의 지갑 크기는 4000(=80 x 50)입니다.
     * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
     * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
     */
    fun solution01(sizes: Array<IntArray>): Int {
        var maxX = 0
        var maxY = 0

        /*
        sizes.forEach { (x, y) ->
            if (x < y) {
                maxX = max(maxX, x)
                maxY = max(maxY, y)
            } else {
                maxX = max(maxX, y)
                maxY = max(maxY, x)
            }
        }
         */

        sizes.forEach { (x, y) ->
            maxX = max(maxX, min(x, y))
            maxY = max(maxY, max(x, y))
        }

        return maxX * maxY
    }

    println("solution01 : 최소직사각형")
    println(solution01(arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40))))
    println(solution01(arrayOf(intArrayOf(10, 7), intArrayOf(12, 3), intArrayOf(8, 15), intArrayOf(14, 7), intArrayOf(5, 15))))
    println(solution01(arrayOf(intArrayOf(14, 4), intArrayOf(19, 6), intArrayOf(6, 16), intArrayOf(18, 7), intArrayOf(7, 11))))
}