class charator {
    var name: String = ""
    var gender: String = ""
    var hp: Int = 0
    var maxhp: Int = 0
    var str: Int = 0
    var def: Int = 0
    var skill1: String = ""
    var skill2: String = ""


    //this is here to keep the code looking cleaner I did have it just as an object but there realling isn't a point for the charater
    fun charatorCreation(){


        println("Welcome to My Kotlin Adventure Game")
        println("What is your name: ")
        val name1 = readln()
        name = name1
        println("Hello, $name!\n what is your gender: ")
        val g = readln()
        gender = g
        println("Choose your class: 1. Warrior 2. Mage 3. Claric")
        val classint = readln()
        if (classint == "1") {
            hp = 70
            maxhp = 70
            str = 10
            def = 10
            skill1 = "Power Strike"
            skill2 = "Backstab"
        }
        else if (classint == "2") {
            hp = 60
            maxhp = 60
            str = 15
            def = 5
            skill1 = "Fireball"
            skill2 = "Ice Spike"
        }
        else if (classint == "3") {
            hp = 80
            maxhp = 80
            str = 10
            def = 15
            skill1 = "Heal"
            skill2 = "Power Strike"
        }


    }
}

