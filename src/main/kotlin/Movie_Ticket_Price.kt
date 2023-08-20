fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    val child = 12
    val adult = 13..60
    val senior = 61..100
    return if (age <= child) {
        15
    } else if(age in adult) {
        if(isMonday) {
            25
        } else {
            30
        }
    } else if (age in senior) {
        20
    } else {
        -1
    }
}