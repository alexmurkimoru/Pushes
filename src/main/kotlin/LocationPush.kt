class LocationPush(
    textParam: String,
    type: PushTypes,
    private val xCoord: Float,
    private val yCoord: Float,
    private val radius: Int,
    private val expiryDate: Long,
) : Push(textParam, type), FilterableByLocation, FilterableByExpireDate {
    override fun isFilteredByApp(systemApp: SystemApp) =
        isFilteredByLocation(systemApp, xCoord, yCoord, radius) || isFilteredByExpireDate(systemApp, expiryDate)
}