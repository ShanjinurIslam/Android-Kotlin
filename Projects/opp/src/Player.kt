//
class Player(
    private val name: String = "",
    private var userName: String = "",
    private var lives: Int = 3,
    private var level: Int = 1,
    private var score: Int = 0,
    var weapon: Weapon
) {
    private var inventory = ArrayList<Loot>() // encapsulation (not exposing how classes work inside the class outside the class) every property is Public by default

    fun addToInventory(loot:Loot){
        inventory.add(loot)
    }

    fun showInventory(){
        for (item in inventory){
            println(item.toString())
        }
    }

    // fun name(parameterName:Type ..) : return-type { ... body ... }
    fun dropLoot(loot:Loot): Boolean {
        return if (inventory.contains(loot)){
            inventory.remove(loot)
            true
        }else{
            false
        }
    }

    // overloading function dropLoot with string as parameter

    fun dropLoot(lootName:String) : Boolean{
        return inventory.removeIf({it.name==lootName})
    }


    override fun toString(): String {
        return "Player(name='$name', userName='$userName', lives=$lives, level=$level, score=$score, weapon=${weapon.toString()})"
    }
}