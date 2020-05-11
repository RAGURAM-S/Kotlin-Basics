import java.util.*;

fun randomDay() : String{
    val week = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday",
                        "Thursday", "Friday", "Saturday")
    return week[Random().nextInt(week.size)]
}

fun food(day : String) : String {
    var food : String = ""
    when(day){
        "Sunday" -> food = "pizzas"
        "Monday" -> food = "burgers"
        "Tuesday" -> food = "burritos"
        "Wednesday" -> food = "cheese sandwiches"
        "Thursday" -> food = "tacos"
        "Friday" -> food = "bacon"
        "Saturday" -> food = "eggs"
    }
    return food
}

fun function(){
    val day = randomDay()
    val foodOfTheDay = food(day)
    val message = "I usually eat $foodOfTheDay on $day"
    print(message)
}

fun main(args : Array<String>){
    function()
}