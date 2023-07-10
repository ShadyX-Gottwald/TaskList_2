package tasklist
import java.util.Scanner;
import kotlin.system.exitProcess;

interface MenuFunction {
    val scanner: Scanner
        get() = Scanner(System.`in`)

    fun getAction(scanner: Scanner,taskManager: TaskManager): Unit
}

enum class Menu(val mode: String):MenuFunction {

    ADD("add") {
        override fun getAction(scanner: Scanner, taskManager: TaskManager): Unit {
            val tasks = ArrayList<Task>()
            println("Input a new task (enter a blank line to end):")

            while (scanner.hasNextLine()) {
                val task = scanner.nextLine()
                    .lineSequence()
                    .joinToString()
                    .trim()

                //Add to local list

                val item = tasks.add(Task(task))
                if(tasks.get(0) == Task("")) { println("The task is blank"); return }

                if (task.isBlank()) {
                    taskManager.addTasks(tasks)
                    return
                }
            }
        }
    },
    END("end") {
        override fun getAction(scanner: Scanner,taskManager: TaskManager) {
            println("Tasklist exiting!")
            exitProcess(0)
        }
    } ,
    PRINT("print") {
        override fun getAction(scanner: Scanner, taskManager: TaskManager) {

            if(taskManager.size == 0) {
                println("No tasks have been input")
                return
            }
            taskManager.showTasks()

        }
    },
    OTHER("") {
        override fun getAction(scan: Scanner, taskManager: TaskManager) {
           println("The input action is invalid")
            return
        }
    }
}