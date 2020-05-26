fun main(args:Array<String>){
    val lives = 3 
    if(lives<1){
        println("Game Over")
    }
    else{
        println("You still have lives")
    }

    var message:String = when{
        lives < 1 -> ""
    }
}