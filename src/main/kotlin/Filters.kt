import kotlin.math.pow
import kotlin.math.sqrt

//Фильтрация по положению. Применяется для пушей типа LocationPush,LocationAgePush.
// Правило: если координаты системы по евклидову расстоянию x_coord, y_coord строго дальше
// от координат пуша на radius из пуша, то пуш должен быть отфильтрован (т.е. не показан).

interface FilterableByLocation {
    fun isFilteredByLocation(systemApp: SystemApp, pushX: Float, pushY: Float, pushRadius: Int): Boolean {
        return pushRadius < sqrt((systemApp.xCoord - pushX).pow(2) + (systemApp.yCoord - pushY).pow(2))
    }
}

//Фильтрация по возрасту. Применяется для пушей типа AgeSpecificPush, LocationAgePush, GenderAgePush.
// Правило: если age, указанный в пуше, строго больше, чем age, заданный системе, то пуш должен
// быть отфильтрован.

interface FilterableByAge {
    fun isFilteredByAge(systemApp: SystemApp, pushAge: Int) = pushAge > systemApp.age
}

//Фильтрация по версии системы. Применяется для TechPush.
// Правило: если os_version в системе строго больше, чем os_version в пуше,
// то пуш должен быть отфильтрован (то есть, пуш показывается на равных и более старых версиях,
// чем указано в пуше).

interface FilterableByOs {
    fun isFilteredByOS(systemApp: SystemApp, pushOsVersion: Int) = pushOsVersion < systemApp.osVersion
}
//Фильтрация по дате протухания пуша. Применяется для LocationPush, AgeSpecificPush.
// Правило: если expiry_date у пуша строго меньше, чем time в системе, то пуш должен быть отфильтрован.

interface FilterableByExpireDate {
    fun isFilteredByExpireDate(systemApp: SystemApp, pushExpireDate: Long) = pushExpireDate < systemApp.time
}
//Фильтрация по полу. Применяется для пушей GenderAgePush, GenderPush.
// Правило: если gender, указанный в системе, отличен от переданного в пуше,
// то пуш должен быть отфильтрован.

interface FilterableByGender {
    fun isFilteredByGender(systemApp: SystemApp, pushGender: Gender) = pushGender.sign != systemApp.gender.sign
}
