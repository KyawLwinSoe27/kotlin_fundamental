fun main() {
    val song = Song("A time of Shindig","Jimmy",2000,2)

    song.songDesc()
}

class Song(private val title: String, private val artist: String, private val published: Int, playCount: Int) {
    val playCount = playCount
    private var popular: Boolean = false

    fun checkPopularity(playCount: Int) {
        if(playCount >= 1000){
            popular = true
        }
    }

    fun songDesc() {
        print("$title, performed by $artist, was released in $published.")
    }
}