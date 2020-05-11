package example.inheritance

interface FishColor{
    val color :String
}

object GoldColor : FishColor{
    override val color : String = "gold"
}

interface FishAction {
    fun eat()
}

class Shark : FishColor, FishAction{
    override val color : String
    get() = "Gray"
    override fun eat(){
        println("Hunts and eats other fish")
    }
}

class Plecostomous : FishColor by GoldColor, FishAction{
    override fun eat(){
        println("Eats algae")
    }
}

sealed class Seal()
class SeaLion() : Seal()
class Walrus() : Seal()

fun matchSeal(seal : Seal) : String{
    return when(seal){
        is SeaLion -> "It's a Sea Lion"
        is Walrus -> "It's a Walrus"
    }
}