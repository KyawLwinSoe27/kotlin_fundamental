fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah",28,"climb",amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(private val name: String, private val age: Int, private val hobby: String?, private val referrer: Person?) {
    private fun hasReferrer() : String {
        return if(referrer != null) {
            "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}"
        } else {
            "Doesn't have a referrer"
        }
    }
    fun showProfile() {
        println("Name : $name")
        println("Age: $age")
        if(hobby != null) {
            println("Likes to $hobby. ${hasReferrer()} ")
        }
    }
}