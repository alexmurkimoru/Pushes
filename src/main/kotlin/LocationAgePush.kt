class LocationAgePush(
    textParam: String,
    type: PushTypes,
    private val xCoord: Float,
    private val yCoord: Float,
    private val radius: Int,
    private val age: Int,
) : Push(textParam, type), FilterableByLocation, FilterableByAge{
    override fun isFilteredByApp(systemApp: SystemApp) = isFilteredByLocation(systemApp, xCoord, yCoord, radius) || isFilteredByAge(systemApp, age)
}