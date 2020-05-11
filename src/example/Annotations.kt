package example

import example.inheritance.decor.callSeal
import kotlin.reflect.full.*;

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAPlant class Plant(){
    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false

    fun trim(){

    }
    fun fertilize(){

    }
}

fun testAnnotations(){
    val classObject = Plant :: class
    for (item in classObject.declaredMemberFunctions){
        println(item.name)
    }
    for (item in classObject.annotations){
        println(item.annotationClass.simpleName)
    }
    val annotationObject = classObject.findAnnotation<ImAPlant>()
    println(annotationObject)
}

fun labeledBreak(){
    outerloop@ for(i in 1..100){
        print("$i ")
        for (j in 1..100){
            if(i > 10){
                break@outerloop
            }
        }
    }
}

fun main(){
    testAnnotations()
    labeledBreak()
}