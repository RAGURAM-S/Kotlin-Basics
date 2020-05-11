package example.inheritance

fun String.hasSpaces() : Boolean{
    val spaces = this.find { it == ' ' }
    return spaces != null
}

fun findSpaces(){
    println("Is there any spaces in this sentence".hasSpaces())
}

fun main(){
    findSpaces()
}

