package example.inheritance

import java.lang.Math.PI;

open class Aquarium(open var length : Int = 100, open var height : Int = 40, open var width : Int = 20) {

    init{
        println("Aquarium initializing...")
    }

//    init{
//        println("Volume of the aquarium ${length * height * width/1000}")
//    }

    constructor(numberOfFish : Int) : this(){
        var tank = numberOfFish * 2000 * 1.1
        height = (tank/(length * width)).toInt()
    }

    open val shape = "rectangle"

    open var volume : Int
        get() = length * height * width /1000
        set(value){
            height = (value * 1000)/(length * width)
        }

    open val water : Double
    get() = volume * 0.9

    open fun printDimensions(){
        println("Length : $length\n" +
                "Height : $height\n" +
                "Width  : $width")
        println("Volume $volume liters \n")
        println("Water content is ${water} l")
        println("The Aquarium is ${water/volume*100}% water\n")
    }
}

class TowerTank(override var height : Int, var diameter : Int) : Aquarium(length = diameter, height = height, width = diameter){

    override var shape : String = "cylinder"

    override var volume : Int
    get() = (height * (width/2) * (length/2) * PI /1000).toInt()
    set(value){
        height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
    }

    override val water : Double
    get() = volume * 0.8

    override fun printDimensions(){
        println("Radius : ${length/2}\n" +
                "Height : $height\n" )
        println("Volume $volume liters")
        println("Water content is ${water} l")
        println("The Aquarium is ${water/volume*100}% water\n")
    }
}