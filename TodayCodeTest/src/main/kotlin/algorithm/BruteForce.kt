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

    println()

    /**
     * solution02 : 모의고사
     * 문제 설명
     * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
     * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
     * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
     * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     */
    fun solution02(answers: IntArray): IntArray {
        // 규칙
        val a = intArrayOf(1, 2, 3, 4, 5)
        val b = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val c = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        // 정답 개수
        val scores = mutableListOf(0, 0, 0)

        // 정답 체크
        answers.forEachIndexed { index, i ->
            if (i == a[index % a.size]) scores[0]++
            if (i == b[index % b.size]) scores[1]++
            if (i == c[index % c.size]) scores[2]++
        }

        // 높은 점수 정답자 오름차순 정렬
        return scores.mapIndexedNotNull { index, i ->
            if (i == scores.maxOrNull()) index + 1
            else null
        }.sorted().toIntArray()
    }

    println("solution02 : 모의고사")
    println(solution02(intArrayOf(1, 2, 3, 4, 5)).toList())
    println(solution02(intArrayOf(1, 3, 2, 4, 2)).toList())
}