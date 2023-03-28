class ControlFlow {
}

fun main() {
    /* ----- For-Each ----- */
    val myData = MyData()
    myData.iterator()

    for (i in myData) {
        print(i)
    }
}


/* ----- If-Else ----- */
fun if_else_식() {
    var a = 5
    var b = 4
    val max = if (a > b) {
        print("Choose a")
        a // 블록의 마지막 구문인 a가 반환값이 된다
    } else {
        print("Choose b")
        b // 블록의 마지막 구문인 b가 반환값이 된다
    }
}



/* ----- When ----- */
class when문 {

    // 기본적인 When 문의 형식
    fun 기본형식(x : Int) {
        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> {
                print("x is neither i nor 2")
            }
        }
    }

    // When문을 '식'으로 다룰때의 예시
    fun when식(x: Int) {
        var res1 = when (x) {
            100 -> "A"
            90 -> "B"
            80 -> "C"
            else -> "F"
        }
    }

    // When문을 '식'으로 다룰때의 예시 2
    // else가 없어도 된다는걸 컴파일러가 입증하면 else를 생략 가능하다
    fun when식2(x: Boolean) {
        var res2 = when (x) {
            true -> "맞다"
            false -> "틀리다"
        }
    }

    // 여러개의 조건이 같은 방식으로 사용될 경우 콤마(,)를 이용하여 표기한다.
    fun 여러개의조건(x: Int) {
        when (x) {
            0, 1 -> print("x == 0 or x == 1")
            else -> print("otherwise")
        }
    }

    // 조건문의 branch에 '식'을 사용 가능하다.
    fun 조건문_식(x: Int) {
        when (x) {
            parseInt(x.toString()) -> print("s encodes x")
            1 + 3 -> print("4")
            else -> print("s does not encode x")
        }
    }

    // 범위 검증
    fun 범위검증(x: Int) {
        val validNums = listOf(3,6,9)
        when (x) {
            in validNums -> print("x is valid")
            in 1..10 -> print("x is in the range")
            !in 10..20 -> print("x is outside the range")
            else -> print("none of the above")
        }
    }

    // 범위 검증 2 스마트 캐스팅
    fun hasPrefix(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    // 파라미터가 없는 When - 파라미터가 없으면 논리연산으로 수행된다
    fun 파라미터가없는When(x: Int) {

        when {
//            x.isOdd() -> print("x is odd")
//            x.isEven() -> print("x is even")
            else -> print("x is funny")
        }
    }
}



/* ----- Loop ----- */

fun 반복() {

    var collection = listOf(1,2,3,4,5)
    collection.iterator()
    for (i in collection)
        print(i)

    val array = arrayOf(1,2,3,4,5)
    array.iterator()
    for (i in array)
        println("$i: $array[i]")
}



/* 연산자 오버로딩을 이용한 For-Each */

/* 아래의 두 클래스를 잘 보자
 - Iterator를 가지고 있지 않는 MyData 객체가 For Each 문에 들어올 수 있다.
 - next(), hasNext()를 가지고 있는 클래스가 있기 때문이다.
 - 핵심은 Iterator를 가지고 있지 않는 MyData 객체가 For Each 문에 들어올 수 있다는 것이다.
 */
class MyIterator {
    val data = listOf(1,2,3,4,5)
    var idx = 0

    operator fun hasNext() : Boolean {
        return data.size > idx
    }

    operator fun next() : Int {
        return data[idx++]
    }
}

// MyIterator 객체를 반환하는 클래스
class MyData {
    operator fun iterator() : MyIterator {
        return MyIterator()
    }
}



/* indices & withIndex() */
class index {

    fun main() {

        // 배열이나 리스트를 index를 이용하여 반복하고 싶을때 사용한다
        val array1 = arrayOf("가", "나", "다")
        for (i in array1.indices) {
            println("$i: ${array1[i]}")
        }

        // index를 이용하고 싶을 때, withIndex()를 사용한다
        // 인덱스와 값이 같이 반환된다
        val array2 = arrayOf("가", "나", "다")
        for ((index, value) in array2.withIndex()) {
            println("$index: ${value}")
        }
    }
}

/* ----- While Loop ----- */
//class while문 {
//    fun 기본구조() {
//        while (x > 0) {
//            x--
//        }
//
//// do 안의 지역변수인 y를 while에서 참조가 가능하다
//        do {
//            val y = retrieveData()
//        } while (y != null) // y is Visible Here !
//    }
//}