fun main(args: Array<String>) {
    // defining objects
    var tim = Player("Andrew", "andrew235", weapon = Weapon(name = "Axe", damage = 12))
    var louise: Player = Player("louise", "louise23", weapon = Weapon(name = "Gun", damage = 23))
    val loot:Loot = Loot(name = "Red Potion",type = LootType.POTION,value = 23.0)
    // adding inventory
    tim.addToInventory(loot)
    louise.addToInventory(Loot(name = "Blue Potion",type = LootType.POTION,value = 32.0))

    // defining arraylist
    var players = ArrayList<Player>()
    players.add(tim)
    players.add(louise)

    //printing details of each players
    for(i in 0 until players.size){
        println(players[i].toString())
    }

//    for(i in 0..players.size){
//        println(players[i].toString())
//    }

    for(i in 0 until players.size){
        println(players[i].dropLoot(loot))
    }

    // use of overloaded function
    if(louise.dropLoot("Blue Potion")){
        println("Blue Potion Removed")
    }else{
        println("You don't have Blue Potion")
    }

    var troll:Troll = Troll("Ugly Troll")
    println(troll.toString())

    var vampire:Vampire = Vampire("Demon")
    vampire.takeDamage(23)
}