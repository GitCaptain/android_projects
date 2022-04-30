package spices

import android.widget.GridLayout

class SimpleSpice {
    var name: String = "curry"
    var spiciness: String = "mild"

    val heat: Int
        get() = 5

}

abstract class Spice(var name: String, var spiciness: String = "mild", color: Color): Color by color {

    abstract fun prepareSpice()

    val heat: Int
        get(){
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }

    init {
        println("ready")
    }

}

interface Grinder {
    fun grind()
}


class Curry(spiciness: String, color: Color = YellowColor): Spice("Curry", spiciness, color), Grinder {

    override fun prepareSpice() {
        grind()
    }

    override fun grind() {

    }
}

enum class eColor(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

interface Color {
    val color: eColor
}

object YellowColor: Color {
    override val color = eColor.YELLOW
}

fun makeSalt() = Curry("some")