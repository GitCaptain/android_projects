package game

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val res = mutableListOf<Int>()
    for (e in this) {
        if(block(e) == 0) {
            res.add(e)
        }
    }
    return res
}

fun divby3(list: List<Int>, flt: List<Int>.() -> List<Int>): List<Int> {
    return list.flt()
}


fun main() {

    val numbers = listOf(1,2,3,4,5,6,7,8,9,0)

    println(numbers.divisibleBy { it.rem(3) })

    println(divby3(numbers) {
        filter { it % 3 == 0 }
    })

}