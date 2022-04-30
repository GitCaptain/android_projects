package spices.data

import spices.Curry
import spices.Spice

data class SpiceContainer(val spice: Spice ) {
    val label = spice.name
}

fun main() {
    println(SpiceContainer(Curry("")))

}