package example.inheritance

fun buildAquarium(){
    var aquarium = Aquarium()
    println("Shape of the aquarium is ${aquarium.shape}")
    aquarium.printDimensions()

    var towerTank = TowerTank(height = 40, diameter = 25)
    println("Shape of the aquarium is ${towerTank.shape}")
    towerTank.printDimensions()
}

fun makeFish(){
    var shark = Shark()
    var plecostomous = Plecostomous()
    println("Shark's color is ${shark.color}")
    shark.eat()
    println("Plecostomous's color is ${plecostomous.color}")
    plecostomous.eat()
}

fun main(){
    buildAquarium()
    makeFish()
}