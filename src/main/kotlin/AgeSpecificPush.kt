class AgeSpecificPush(
    textParam: String,
    type: PushTypes,
    private val age: Int,
    private val expiryDate: Long,
) : Push(textParam, type), FilterableByAge, FilterableByExpireDate {
    override fun isFilteredByApp(systemApp: SystemApp) = isFilteredByAge(systemApp, age) || isFilteredByExpireDate(systemApp, expiryDate)
}