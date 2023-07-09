package tasklist

data class Task(val content: String) {
    val tasks = ArrayList<String>()

    override fun toString(): String = content
}