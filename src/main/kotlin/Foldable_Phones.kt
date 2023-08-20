fun main() {
    var foldablePhone = FoldablePhone()

    foldablePhone.checkPhoneFoldable()
    foldablePhone.checkPhoneScreenLight()

    if(25 % 10 == 0) {
        println("Di")
    } else if(25 == 5) {
        println("5")
    } else {
        println("n")
    }
}

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    open fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone() : Phone() {

    var isFolded = true

    fun checkPhoneFoldable() {
        if(isFolded) {
            switchOn()
        } else {
            switchOff()
        }
    }
}