package tasklist

class  TaskManager (
    private var taskList: ArrayList<Task>
){
    val size: Int
        get() = this.taskList.size

    fun addTask(task: Task) = taskList.add(task);

    fun showTasks() = taskList.forEachIndexed{ index: Int, task: Task ->
        println(
            if(index+1 <=9) "${index+1}  $task" else "${index+1} $task"
        )
    }


}