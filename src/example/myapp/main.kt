package example.myapp

fun buildAquarium(){
    var aquarium1 = Aquarium()
    aquarium1.printDimensions()

    var aquarium2 = Aquarium(width = 25)
    aquarium2.printDimensions()

    var aquarium3 = Aquarium(height = 60, width = 25)
    aquarium3.printDimensions()

    var aquarium4 = Aquarium(length = 120, height = 60, width = 25)
    aquarium4.printDimensions()

    var aquarium5 = Aquarium(numberOfFish = 29)
    aquarium5.printDimensions()
    aquarium5.volume = 70
    aquarium5.printDimensions()
}

fun main(){
    buildAquarium()
}