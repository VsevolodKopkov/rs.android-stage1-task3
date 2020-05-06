package subtask2

class Combinator {

    // TODO: Complete the following function
    var l = 1L
    var r = 0L

    fun checkChooseFromArray(array: Array<Int>): Int? {
        if (array.isNullOrEmpty()) return null

        while (r < array[0] && l != array[1].toLong()) {
            r = factorial(array[1].toLong()).div(factorial(l).times(factorial(array[1].minus(l))))
            l++
        }
        return if (r == array[0].toLong()) l.minus(1L).toInt()
        else null
    }

    private fun factorial(num: Long) = (1L..num).reduce(Long::times)

}
