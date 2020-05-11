package example.inheritance.decor

import example.inheritance.SeaLion
import example.inheritance.Walrus
import example.inheritance.matchSeal

fun makeDecorations(){

    var decorations = Decorations(rocks = "crystal", wood = "wood", diver = "divers")
    println(decorations)

    val(rocks, wood, diver) = decorations
    println(rocks)
    println(wood)
    println(diver)
}

fun callSeal(){
    val seaLion = SeaLion()
    val walrus = Walrus()
    println(matchSeal(seaLion))
    println(matchSeal(walrus))
}

fun main(){
    makeDecorations()
    callSeal()
}