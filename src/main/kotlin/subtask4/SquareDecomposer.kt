package subtask4

import kotlin.math.pow

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decompose(number.toLong(), number.toDouble().pow(2).toLong())?.toTypedArray()
    }

    private fun decompose(num: Long, pow: Long): MutableList<Int>? {
        for (i in num.minus(1) downTo 1) {
            val dif = pow.minus(i.toDouble().pow(2)).toLong()
            if (dif > 0) {
                val resultSet = decompose(i, dif)
                resultSet?.let {
                    it.add(i.toInt())
                    return it
                }
            } else if (dif == 0L) {
                return mutableListOf(i.toInt())
            }
        }
        return null
    }
}
