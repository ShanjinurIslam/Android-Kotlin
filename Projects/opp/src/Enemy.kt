open class Enemy(protected val name:String,protected var hitPoints:Int, private var health:Int, protected var lives:Int) { // open keyword -> explicitly telling kotlin that this class can be extended
    open fun takeDamage(damage:Int){
        val remainingHitPoints = hitPoints-damage
        if(remainingHitPoints>0){
            hitPoints = remainingHitPoints
            println("$name took $damage points of damages and has $hitPoints left")
        }
        else{
            lives -= 1
            println("$name lost life")
        }
    }

    override fun toString(): String {
        return "Enemy(name='$name', hitPoints=$hitPoints, health=$health, lives=$lives)"
    }
}