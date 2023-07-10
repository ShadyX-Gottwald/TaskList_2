package tasklist

import java.util.*
import kotlin.collections.ArrayList

class Main {
    companion object {
        private lateinit var taskManager: TaskManager
        private lateinit var scanner: Scanner

        @JvmStatic
        fun main(args: Array<String>) {
            taskManager = TaskManager()
            scanner = Scanner(System.`in`)

            while(true) selectMenuAction()
        }

        private fun selectMenuAction() {
            println("Input an action (add, print, end):")

            when (scanner.nextLine()) {
                Menu.ADD.mode -> Menu.ADD.getAction(scanner = scanner, taskManager = taskManager)
                Menu.END.mode -> Menu.END.getAction(scanner = scanner, taskManager = taskManager)
                Menu.PRINT.mode -> Menu.PRINT.getAction(scanner = scanner, taskManager = taskManager)

                else -> Menu.OTHER.getAction(scanner = scanner, taskManager = taskManager)
            }
        }
    }
}


