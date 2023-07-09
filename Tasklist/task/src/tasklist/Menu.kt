package tasklist
import java.util.Scanner;
interface MenuFunction {
    fun getAction(scan: Scanner): Unit
}

enum class Menu(val mode: String):MenuFunction {

    ADD("add"){
        override fun getAction(scan: Scanner): Unit = scan.use{ sc->
                while(sc.hasNextLine()) {
                    val task: String = scan
                        .nextLine()
                        .lineSequence()
                        .joinToString()
                        .trim()

                    if(task.isBlank()) return
                }
            }

    }

}