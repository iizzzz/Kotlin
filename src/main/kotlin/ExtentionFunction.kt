class ExtentionFunction {
}

// 부모 클래스 Shape
open class Shape

// Rectangle 클래스가 Shape 클래스를 상속 받음.
class Rectangle : Shape()

// Shape 클래스의 확장 함수 getName()
fun Shape.getName() = "shape"

// Rectangle 클래스의 확장함수 getName
fun Rectangle.getName() = "rectangle"

// 확장함수 호출
fun printClassName(s : Shape){
    println(s.getName())
}

// 결과값 : shape
// printClassName(Rectangle())



/* ------------------- */

class Car {
    fun shape(str : String) {
        println("빨강")
    }

    fun num(int : Int) {
        println("1")
    }
}

// 함수명, 파라미터 타입이 같은 확장함수, 출력 불가능 (무시됨)
fun Car.shape(str : String) {
    println("노랑")
}

// 함수명은 같지만 파라미터 타입이 다르므로 출력이 가능하다.
fun Car.num(str : String) {
    println("2")
}

fun main() {
    Car().shape("A")
    Car().num(1)
    Car().num("B")
}

/* 결과값
- 빨강
- 1
- 2
 */
