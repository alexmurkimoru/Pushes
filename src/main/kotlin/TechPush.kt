class TechPush(
    textParam: String,
    type: PushTypes,
    private val osVersion : Int,
) : Push(textParam, type), FilterableByOs {
    override fun isFilteredByApp(systemApp: SystemApp) = isFilteredByOS(systemApp, osVersion)
}