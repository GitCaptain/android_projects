package com.example.kotlinlearn

import kotlin.random.Random

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    val totalLength = fishSize + currentFish.sum();
    val sizeMultiplier = if (hasDecorations) 0.8 else 1.0
    return tankSize * sizeMultiplier >= totalLength;
}

fun filtertest() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    val x = spices.sortedBy { it.length }.asSequence().filter {  it[0] == 'c' && it.last() == 'e'}
    println (x.first())
    println(spices.slice(0..2).filter { it[0] == 'c' })
}

val rollDice = {sides: Int -> Random.nextInt(sides + 1) }
fun rollDice2(sides: Int) = Random.nextInt(sides + 1)

fun main(args: Array<String>) {
    println(rollDice(3))
    println(rollDice(3))
    println(rollDice2(0))
    println(rollDice2(0))
    filtertest()
    while(false) {
        println(canAddFish(10.0, listOf(3, 3, 3)))
        println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
        println(canAddFish(9.0, listOf(1, 1, 3), 3))
        println(canAddFish(10.0, listOf(), 7, true))
    }

    val b = Book("CryptoNomikon", "Stevenson, Neal", "1999")
    val (title, author, year) = b.getTitleAndAuthorAndYear()
    println("Here is your book $title written by $author in $year.")

    val allBooks = setOf("romeo and juleta")
    val library = mapOf(
        "shekspir" to allBooks,
    )
    library.any{it.value.contains("hamlet")}
    val moreBooks = mutableMapOf("kek" to "lol")
    moreBooks.getOrPut("key") { "value" }

}
