abstract class Push(
    protected val textParam: String,
    protected val type: PushTypes
) {
    val text = textParam

    abstract fun isFilteredByApp(systemApp: SystemApp): Boolean
}