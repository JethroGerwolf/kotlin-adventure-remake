import kotlin.random.Random

// mobster object
class Mob (var name: String, var hp: Int, var str: Int, var def: Int)

//run function
fun main() {
    val char = charator()
    char.charatorCreation()
    storyLine(char)
}
// the battling function remade
fun battle (m: Mob, c: charator){
    var b = 0
    while (b == 0) {
        println("Your Health: " + c.hp + "/" + c.maxhp)
        println("\nChoose your action: 1. Attack 2. Defend .3 Skill\n\n")
        val a = readln()
        if (a == "1") {
            val pd = (Random.nextInt(5, 10) + c.str) - m.def
            m.hp -= pd
            println("You dealt " + pd + " damage to " + m.name + ".")
            if (m.hp <= 0) {
                println("You killed " + m.name + ".")
                break
            } else {
               b = mobatack(m, c)
            }
        } else if (a == "2") {
            println("You Defended")
            c.hp -= 2
            println(m.name + " did " + 2.toString() + " to you.")
            println("the fight continues...")
            sleep(4)
                if (c.hp <= 0){
                println("You died")
                    sleep(5)
                break
            }

        } else if (a == "3") {
            println("which skill do you want to you 1: " + c.skill1 + " 2: " + c.skill2)
            val s = readln()
            if (s == "1"){
                skills(m, c, c.skill1)
                b = mobatack(m, c)


            }
            else if (s == "2"){
                skills(m, c, c.skill2)
                b = mobatack(m, c)


            }

        }




    }

}
fun sleep(seconds: Int) {
    Thread.sleep(seconds * 1000L)
}

// Clear Screen
fun clearScreen() {
    for (i in 1..10  ) {

        println()
    }
}
// where all the magic happens
fun storyLine(c: charator) {

    //mob object added in
    val mob1 = Mob("Goblin", 30, 8, 5)
    val mob2 = Mob("wolf", 50, 17, 5)
    val mob3 = Mob("Troll", 80, 10, 8)
    val mob4 = Mob("Orc", 50, 12, 8)
    val mob5 = Mob("Dragon", 100, 15, 10)




    clearScreen()
    println("You wake up in a dark forest with no memory of how you got there.")
    println("As you stand up, you hear rustling in the bushes nearby.")
    println("A wild goblin jumps out, ready to attack!")


    // Start battle
    battle(mob1, c)
    println("Finishing the fight you see three paths ahead of you. ")
    while (true) {
        println("\n1. A open plains to the left.\n2. A swamp straight ahead.\n3. A dense forest to the right.")
        val pathChoice = readln().toInt()
        when (pathChoice) {
            1 -> {
                println("You chose the open plains.")
                sleep(6)
                clearScreen()
                println("As you walk through the open plains, A wild wolf appears!")

                // Start battle
                battle(mob2, c)
                println("As you finish the battle, You realized that you are back at the starting point of your adventure.")
            }

            2 -> {
                println("You chose the swamp.")
                sleep(6)
                clearScreen()
                println("as you slosh through the murky waters, A wild orc emerges from the shadows!")

                // Start battle
                battle(mob4, c)
                println("As you finish the battle, You realized that you are back at the starting point of your adventure.")
            }

            3 -> {
                println("You chose the dense forest.")
                sleep(6)
                clearScreen()
                println("As you navigate through the thick trees, A wild troll lumbers into your path!")
                // Start battle
                battle(mob3, c)
                println("As you finish the battle")
                break
            }

            else -> {
                println("Invalid choice. The adventure ends here.")

            }
        }
    }
        //the ending of the game
        println("As you pull away fom the Troll you see a Cave entrance ahead of you and that you when you remember your purpose was to slay the Dragon and same the princess.")
        println("You walk towards the cave to face your next challenge.")
        sleep(6)
        clearScreen()
        println("As you enter the dark cave, A fearsome Dragon descends from above, blocking your path!")

        // Start battle
        battle(mob5, c)
        println("With the Dragon defeated, you rescue the princess and complete your quest!")
        println("Congratulations, " + c.name + "! You have completed your adventure.")
}

// damage cal for mod
fun mobatack(m : Mob, c :charator): Int {

    var a = 0

    val md = (Random.nextInt(5, 10) + m.str) - c.def
    if (md >= 1) {
        c.hp -= md
        println(m.name + " did " + md.toString() + " to you.")
    } else {
        c.hp -= 2
        println(m.name + " did " + 2.toString() + " to you.")

    }
    if (m.hp <= 0){
        println("You killed " + m.name)
        a = 1
    }
    else if (c.hp <= 0){
        println("You died")
        a = 1
    }
    sleep(4)


    return a
}

// skills tree and actions
fun skills(m : Mob, c : charator, sk: String) {

    when (sk) {
        "Power Strike" -> {
            val pk = (Random.nextInt(10, 21) + c.str) - m.def
            m.hp -= pk
            println("You used " + sk + " and did " + pk + " damage to " + m.name + ".")
        }

        "Backstab" -> {
            val pk = (Random.nextInt(10, 31) + c.str) - m.def
            m.hp -= pk
            println("You used " + sk + " and did " + pk + " damage to " + m.name + ".")
        }

        "Fireball" -> {
            val pk = (Random.nextInt(20, 31) + c.str) - m.def
            m.hp -= pk
            println("You used " + sk + " and did " + pk + " damage to " + m.name + ".")
        }

        "Ice Spike" -> {
            val pk = (Random.nextInt(20, 31) + c.str) - m.def
            m.hp -= pk
            println("You used " + sk + " and did " + pk + " damage to " + m.name + ".")
        }

        "Heal" -> {
            if (c.hp == c.maxhp) {
                println("You are already at full health.")

            } else {
                if (c.maxhp - c.hp < 10) {
                    val healAmount: Int = c.maxhp - c.hp
                    c.hp += healAmount
                    println("You used Heal and restored " + healAmount + " health.")
                } else {
                    c.hp += 10
                    println("You used Heal and restored 10 health.")
                }
            }
        }

        else -> {
            println("You fomble")
        }
    }

}

