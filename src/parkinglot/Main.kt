package parkinglot

import java.util.Scanner

import parkinglot.engine.Parking
import parkinglot.engine.Vehicle


fun main() {
    val scanner = Scanner(System.`in`)
    var parking = Parking(0)
    var exit = false

    while (!exit) {
        val userInput = scanner.nextLine()
        val cmd = userInput.split(' ', limit = 3)

        if (cmd[0] == "exit") {
            exit = true
        } else if (cmd[0] == "create") {
            parking = Parking(cmd[1].toInt())
            println("Created a parking lot with ${cmd[1]} spots.")
        } else if (parking.size > 0) {
            when (cmd[0]) {
                "status" -> parking.displayStatus()
                "park" -> parking.parkVehicle(cmd[1], cmd[2])
                "leave" -> parking.leaveSpot(cmd[1].toInt())
                "spot_by_reg" -> parking.getSpotById(cmd[1])
                "spot_by_color" -> parking.getSpotByColor(cmd[1])
                "reg_by_color" -> parking.getIdByColor(cmd[1])
            }
        } else {
            println("Sorry, parking lot is not created.")
        }
    }
}
