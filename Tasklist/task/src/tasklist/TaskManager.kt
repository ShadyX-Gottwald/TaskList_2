package tasklist

class  TaskManager  {

    private val allTasks = ArrayList<ArrayList<Task>>()
     val size: Int
        get() = this.allTasks.size

   // fun addTask(task: Task) = taskList.add(task);

    fun showTasks() = allTasks.forEachIndexed{ index: Int, task: ArrayList<Task> ->
        println(
            if(index+1 <=9) "${index+1}  ${task[0]}" else "${index+1} ${task[0]}"+ "\n"
        )
        for(i in 1 until task.size-1){
            println("   ${task[i].content}")
        }
        println("")
    }

    fun addTasks( tasks: ArrayList<Task> ){
        if(tasks.isEmpty()) throw IllegalStateException("The task is blank")
        this.allTasks.add(tasks)
    }
}