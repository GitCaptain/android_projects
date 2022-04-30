package spices

fun main(args: Array<String>) {
    val sp = makeSalt()
    val spices1 = listOf<Spice>(
//        Spice("curry", "mild"),
//        Spice("pepper", "medium"),
//        Spice("cayenne", "spicy"),
//        Spice("ginger", "mild"),
//        Spice("red curry", "medium"),
//        Spice("green curry", "mild"),
//        Spice("hot pepper", "extremely spicy")
    )
    println("${sp.name} ${sp.heat}")
}