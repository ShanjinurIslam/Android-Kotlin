class Vampire(name: String) : Enemy(name, hitPoints=200, health=200, lives=3) {
    override fun takeDamage(damage:Int){
        val remainingHitPoints = super.hitPoints-damage
        if(remainingHitPoints>0){
            hitPoints = remainingHitPoints
            println("$name took $damage points of damages and has $hitPoints left")
        }
        else{
            lives -= 1
            println("$name lost life")
        }
    }
}