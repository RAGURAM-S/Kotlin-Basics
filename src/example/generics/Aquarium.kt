package example.generics

import java.awt.event.WindowAdapter

open class WaterSupply(var needsProcessing : Boolean)

class TapWater : WaterSupply(needsProcessing = true){
    fun addChemicalCleaners(){
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(needsProcessing = false)

class LakeWater : WaterSupply(needsProcessing = true){
    fun filter(){
        needsProcessing = false
    }
}

class Aquarium <out T : WaterSupply >(val waterSupply : T){

    fun addWater(cleaner : Cleaner<T>){
        if(waterSupply.needsProcessing){
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }

    inline fun <reified R : WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

inline fun <reified  T : WaterSupply> WaterSupply.isOfType() = this is T

interface Cleaner<in T : WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater){
        waterSupply.addChemicalCleaners()
    }
}

fun addItem(aquarium: Aquarium<WaterSupply>) = println("Item added!!")

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>){
    println("the aquarium is clean ${aquarium.waterSupply.needsProcessing}")
}

fun genericExample(){
    val aquarium = Aquarium<TapWater>(TapWater())
    println("water needs processing ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing ${aquarium.waterSupply.needsProcessing}")


    val aquarium2 = Aquarium(TapWater())
    val cleaner = TapWaterCleaner()
    addItem(aquarium2)
    aquarium2.addWater(cleaner)
    isWaterClean(aquarium2)
    aquarium2.hasWaterSupplyOfType<TapWater>()
    aquarium2.waterSupply.isOfType<TapWater>()
}

fun main(){
    genericExample()
}