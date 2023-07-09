package tasklist

import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

class Main {

    companion object {
        private lateinit var taskManager: TaskManager
        private lateinit var scanner: Scanner

        @JvmStatic
        fun main(args: Array<String>) {
            taskManager = TaskManager(ArrayList())
            scanner = Scanner(System.`in`)

            println("Input the tasks (enter a blank line to end):")
            //println("\u001B[101m \u001B[8m")


            scanner.use { scan ->
                while (scan.hasNextLine()) {
                    val task: String = scan
                        .nextLine()
                        .lineSequence()
                        .joinToString()
                        .trim()

                    if(task.isBlank()) addAllTasks(task,scan)
                   // println(task)
                    addAllTasks(task,scan)
                }
            }
        }

        private fun addAllTasks(task: String,scan: Scanner): Any = try {

            if (task.isBlank()) {
                scan.close()
                if(taskManager.size == 0) throw IllegalArgumentException("No tasks have been input")
                else throw Exception()
            }

            taskManager.addTask(Task(task))

        } catch (e: IllegalArgumentException) {
            println(e.message)
            exitProcess(0)

        } catch (e: Exception) {
            taskManager.showTasks()
            exitProcess(0)
        }
    }
}

