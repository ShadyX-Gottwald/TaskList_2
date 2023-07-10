package tasklist


data class Task(val content: String) {

    override fun toString(): String = content
}