class OperatorOverloading {

    fun main() {
        /* ----- 이항 산술 연산 오버로딩 ----- */
        val point1 = Point(10, 20)
        val point2 = Point(30, 40)
        // 결과값 : Point(x=40, y=60)
        println(point1 + point2)

        /* 결과 타입이 피연산자 타입과 전혀 다른 연산자 정의 */
        val pointA = Point(10, 20)
        // 결과값 : Point(x=15, y=30)
        println(pointA * 1.5)

        // 연산자를 정의할 때 두 파라미터가 같은 타입을 필요가 없다
        // 결과값 : AAA
        println('A' * 3)



        /* ----- 단항 연산 오버로딩 ----- */
        val pointB = Point(10, 20)

        // 결과값 : Point(x = -10, y = -20)
        println(-pointB)
    }



    /* ----- 이항 산술 연산 오버로딩 ----- */
    data class Point(val x: Int, val y: Int) {

        // 연산자를 확장 함수로 정의
        operator fun plus(other: Point): Point {
            return Point(x + other.x, y + other.y)
        }
    }

    /* 두 파라미터의 타입이 서로 다른 확장 함수 정의 */
    operator fun Point.times(scale: Double) : Point {
        return Point( (x * scale).toInt(), (y * scale).toInt() )
    }

    /* 결과 타입이 피연산자 타입과 전혀 다른 연산자 정의 */
    operator fun Char.times(count: Int) : String {
        return this.toString().repeat(count)
    }



    /* ----- 단항 산술 연산 오버로딩 ----- */
    operator fun Point.unaryMinus() : Point {
        // 각 좌표에 -(음수)를 취한 좌표 반환
        return Point(-x, -y)
    }



    /* ----- 비교연산 오버로딩 ----- */
    class Compare(val x: Int, val y: Int) {
        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }
    }
}
