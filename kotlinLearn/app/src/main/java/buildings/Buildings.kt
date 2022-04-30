package buildings

sealed class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood: BaseBuildingMaterial(4)
class Brick: BaseBuildingMaterial(8)

class Building<out T: BaseBuildingMaterial> (private val material: T, private val baseMaterialsNeeded: Int = 100) {

    val actualMaterialNeeded: Int
        get() = material.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("$actualMaterialNeeded ${material::class.simpleName} required")
    }

}

fun <T: BaseBuildingMaterial> isSmallBuilding(b: Building<T>) {
    println("${if (b.actualMaterialNeeded < 500) "small" else "large" } building")
}
