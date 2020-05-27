class Weapon(private var name:String="",private var damage:Int=1) {
    override fun toString(): String {
        return "Weapon(name='$name', damage=$damage)"
    }
}