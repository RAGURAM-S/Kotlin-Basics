import java.util.*

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

// compact functions

fun getTemperatureReading() : Int = Random().nextInt(100)

fun getDirtySensorReading() : Int = Random().nextInt(50)

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}
// compact functions

fun isSunday(day : String) : Boolean = day == "Sunday"

fun isDirty(dirty: Int) : Boolean = dirty > 25

fun isTooHot(temperature : Int) : Boolean = temperature > 30

fun randomDaySelection() : String{
    val week = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday",
                        "Thursday", "Friday", "Saturday")
    return week[Random().nextInt(week.size)]
}

fun filterExamples(){

    // eager filter
    val eager = decorations.filter { it[0] == 'p' }
    println("eager " + eager)

    // lazy filter
    val lazy = decorations.asSequence().filter { it[0] == 'p' || it[0] == 'r' }.map {
        println("access : $it")
        it
    }
    println("----------")
    println("filtered : ${lazy.toList()}")

    // visualization of lazy filter

    val lazyMap = decorations.asSequence().map {
        println("access : $it")
        it
    }

    println("lazy : $lazyMap")
    println("----------------------------")
    println("first : ${lazyMap.first()}")
    println("----------------------------")
    println("all : ${lazyMap.toList()}")
}
// lambda
var waterFilter : (Int) -> Int = { dirty -> dirty/2 }

fun feedFish( dirty : Int) = dirty + 10

// higher order function
fun updateDirtyLevel( dirty : Int, operation : (Int) -> Int) : Int {
    return operation(dirty)
}

var dirty = 20

fun dirtyProcessor(){
    // higher order functino -- passing lambda function as arguments to another function
    dirty = updateDirtyLevel(dirty, waterFilter)
    // higher order function -- passing named function as arguments to another function
    dirty = updateDirtyLevel(dirty, ::feedFish)
    // higher order functino -- passing a lambda as arguments
    dirty = updateDirtyLevel(dirty, { dirty -> dirty + 50})
    print("dirty " + dirty)
}

fun changeWater(day : String, dirty : Int = getDirtySensorReading(), temperature : Int = getTemperatureReading()) : Boolean{
    return when {
        isSunday(day) -> true
        isDirty(dirty) -> true
        isTooHot(temperature) -> true
        else -> false
    }
}

fun feedTheFish() {
    val day = randomDaySelection()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("Change the water : ${changeWater(day)}")
}

fun main(args: Array<String>) {
    feedTheFish()
    filterExamples()
    println("--------------*******---------------")
    dirtyProcessor()
}
