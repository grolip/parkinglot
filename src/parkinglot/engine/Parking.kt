package parkinglot.engine

import parkinglot.engine.Vehicle


class Parking (val size: Int) {
    val spots: MutableList<Vehicle> = mutableListOf()

    fun isFreeSpot(index: Int): Boolean {
        for (spot in this.spots) {
            if (spot.spot == index)
                return false
        }
        return true
    }

    fun getFreeSpot(): Int {
        for (i in 1..this.size) {
            if (isFreeSpot(i))
                return i
        }
        return -1
    }

    fun getSpotByColor(color: String) {
        val result: MutableList<Int> = mutableListOf()
        for (spot in this.spots) {
            if (spot.color.toLowerCase() == color.toLowerCase())
                result.add(spot.spot)
        }
        if (result.size > 0)
            println(result.joinToString(", "))
        else
            println("No cars with color $color were found.")
    }

    fun getSpotById(id: String) {
        val result: MutableList<Int> = mutableListOf()
        for (spot in this.spots) {
            if (spot.id == id)
                result.add(spot.spot)
        }
        if (result.size > 0)
            println(result.joinToString(", "))
        else
            println("No cars with registration number $id were found.")
    }

    fun getIdByColor(color: String) {
        val result: MutableList<String> = mutableListOf()
        for (spot in this.spots) {
            if (spot.color.toLowerCase() == color.toLowerCase())
                result.add(spot.id)
        }
        if (result.size > 0)
            println(result.joinToString(", "))
        else
            println("No cars with color $color were found.")
    }

    fun parkVehicle(id: String, color: String) {
        if (this.size == this.spots.size) {
            println("Sorry, parking lot is full.")
        } else {
            val freeSpot = getFreeSpot()
            this.spots.add( Vehicle(id, color, freeSpot) )
            // Conserver ordre selon place attribuée
            this.spots.sortBy { it.spot }
            println("$color car parked on the spot $freeSpot.")
        }
    }
    
    fun leaveSpot(index: Int) {
        if (index <= this.spots.size && !isFreeSpot(index)) {
            this.spots.removeAt(index - 1)
            println("Spot $index is free.")
        } else {
            println("There is no car in the spot $index.")
        }
    }

    fun displayStatus() {
        for (spot in this.spots)
            println("${spot.spot} ${spot.id} ${spot.color}")
        if (this.spots.size == 0)
            println("Parking lot is empty.")
    }

}
