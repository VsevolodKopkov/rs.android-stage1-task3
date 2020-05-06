package subtask1

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        val stringPolynomial: ArrayList<String?> = arrayListOf()
        var x = numbers.size
        val number = numbers.toCollection(ArrayList())

        if (number.isEmpty()) {
            return null
        } else {
            for (i in number.indices) {
                when {

                    number[i] == 0 -> {
                        x -= 1
                        stringPolynomial.remove("0")
                    }

                    x == 1 -> {
                        stringPolynomial.add("+ ${number[i]}")
                    }

                    number[i] == -1 -> {
                        x -= 1
                        stringPolynomial.add("- x")
                    }

                    number[i] > 0 -> {
                        if (x == number.size) {
                            x -= 1
                            if (x == 1) {
                                stringPolynomial.add("${number[i]}x")
                            }else{
                            stringPolynomial.add("${number[i]}x^${x}")}
                        } else {
                            x -= 1
                            if (x == 1) {
                                stringPolynomial.add("+ ${number[i]}x")
                            }else {
                                stringPolynomial.add("+ ${number[i]}x^${x}")
                            }
                        }
                    }

                    number[i] < 0 -> {
                        if (x == number.size) {
                            x -= 1
                            if (x == 1) {
                                stringPolynomial.add("${number[i] * -1}x")
                            }else{
                            stringPolynomial.add("${number[i] * -1}x^${x}")}
                        } else {
                            x -= 1
                            if (x == 1) {
                                stringPolynomial.add("- ${number[i] * -1}x")
                            }else{
                            stringPolynomial.add("- ${number[i] * -1}x^${x}")}
                        }
                    }

                }
            }

            return stringPolynomial.joinToString(separator = " ")
        }
    }
}
