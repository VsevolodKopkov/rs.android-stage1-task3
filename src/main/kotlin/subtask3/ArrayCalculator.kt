package subtask3

import kotlin.math.abs

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {

        var clAr =
            itemsFromArray.filterIsInstance<Int>()
        if (clAr.isNullOrEmpty()) return 0

        if (numberOfItems >= clAr.size) return clAr.reduce(Int::times)

        return clAr.sortedByDescending { abs(it) }.let {
            var i = 1
            repeat(numberOfItems) { count ->
                i *= it[count]
            }

            if (i < 0) {
                i = 1
                repeat(numberOfItems.plus(1)) { count ->
                    if (count != 0) i *= it[count]
                }
            }
            println(numberOfItems)
            println(it)
            i
        }
    }
}
