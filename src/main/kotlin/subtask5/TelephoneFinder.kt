package subtask5

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.toLong() < 0) return null

        val outcome = mutableListOf<String>()
        val list = number.map {
            it.toString().toInt()
        }

        list.forEachIndexed { i, n ->
            when(n) {
                0 -> {
                    outcome.add(iteration(i, 8, list.toMutableList()))
                }
                1 -> {
                    outcome.add(iteration(i, 2, list.toMutableList()))
                    outcome.add(iteration(i, 4, list.toMutableList()))
                }
                2 -> {
                    outcome.add(iteration(i, 1, list.toMutableList()))
                    outcome.add(iteration(i, 5, list.toMutableList()))
                    outcome.add(iteration(i, 3, list.toMutableList()))
                }
                3 -> {
                    outcome.add(iteration(i, 2, list.toMutableList()))
                    outcome.add(iteration(i, 6, list.toMutableList()))
                }
                4 -> {
                    outcome.add(iteration(i, 1, list.toMutableList()))
                    outcome.add(iteration(i, 5, list.toMutableList()))
                    outcome.add(iteration(i, 7, list.toMutableList()))
                }
                5 -> {
                    outcome.add(iteration(i, 2, list.toMutableList()))
                    outcome.add(iteration(i, 4, list.toMutableList()))
                    outcome.add(iteration(i, 6, list.toMutableList()))
                    outcome.add(iteration(i, 8, list.toMutableList()))
                }
                6 -> {
                    outcome.add(iteration(i, 3, list.toMutableList()))
                    outcome.add(iteration(i, 5, list.toMutableList()))
                    outcome.add(iteration(i, 9, list.toMutableList()))
                }
                7 -> {
                    outcome.add(iteration(i, 4, list.toMutableList()))
                    outcome.add(iteration(i, 8, list.toMutableList()))
                }
                8 -> {
                    outcome.add(iteration(i, 5, list.toMutableList()))
                    outcome.add(iteration(i, 7, list.toMutableList()))
                    outcome.add(iteration(i, 9, list.toMutableList()))
                    outcome.add(iteration(i, 0, list.toMutableList()))
                }
                9 -> {
                    outcome.add(iteration(i, 6, list.toMutableList()))
                    outcome.add(iteration(i, 8, list.toMutableList()))
                }
            }
        }
        return outcome.toTypedArray()
    }

    private fun iteration(i: Int, item: Int, list: MutableList<Int>): String {
        list[i] = item
        return list.joinToString("")
    }
}