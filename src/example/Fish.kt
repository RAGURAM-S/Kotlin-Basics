package example

data class Fish(val name : String)

fun nameFish(){
    val fish = Fish("splashy")
    with( fish.name ){
        println(this.capitalize())
    }
    fish.run {
        println("printing inside the run block --> $name")
    }

}

fun explainingWithFunction( name : String, block : String.() -> Unit ){
    name.block()
}

fun namingFishes(){
    val fishes = Fish(name = "flashy")

    explainingWithFunction(fishes.name){
        println(this.capitalize())
    }

    explainingWithFunction(fishes.name, object : Function1<String, Unit> {
        override fun invoke(name : String){
            println("higher order function --> ${name.capitalize()}")
        }
    })

    println(fishes.let { it.name.capitalize() }
            .let { it + " Hello" }
            .let { it.length }
            .let { it + 7 + 23})
    println(fishes)

}

fun runExample(){
    val running = object : Runnable {
        override fun run() {
            println("Hello there...!")
        }
    }
    JavaRun.runNow(running)
}

fun runLambda(){
    JavaRun.runNow(
            {println("Hello there lambdas...!")}
    )
}

fun main(){
    nameFish()
    namingFishes()
    runExample()
    runLambda()
}