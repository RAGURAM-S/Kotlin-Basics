package example.myapp

open class Aquarium(length : Int = 100, height : Int = 40, width : Int = 20) {
    var length: Int = length
    var height: Int = height
    var width: Int = width

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

    var volume : Int
        get() = length * height * width /1000
        set(value){
            height = (value * 1000)/(length * width)
        }

    fun printDimensions(){
        println("Length : $length\n" +
                "Height : $height\n" +
                "Width  : $width")
        println("Volume $volume liters \n")
    }
}
