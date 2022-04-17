package ru.netology

fun main() {

    val card = "VkPay"
    val transferAmount = 10000000
    val transferInMonth = 0

    calculation(card, transferAmount, transferInMonth)
}

fun calculation(
    card: String,
    transferAmount: Int,
    transferInMonth: Int
) {
    if (card == "VkPay" && (transferAmount > 15000 || transferInMonth > 40000)) {
        println("You're over the transfer limit")
    } else if (transferAmount < 150000 && transferInMonth < 600000) {
        val commission = checkCard(card, transferAmount, transferInMonth)
        println("Your commission: $commission kopecks")
    }
}

fun checkCard(card: String, transferAmount: Int, transferInMonth: Int): Int =

    when (card) {
        "VkPay" -> 0
        "Mastercard", "Maestro" -> {
            if (transferInMonth <= 75000) 0 else ((transferAmount * 0.06 + 20) * 100).toInt()
        }
        "Visa", "Mir" -> {
            if (((transferAmount * 0.075) * 100).toInt() < 3500) 3500 else ((transferAmount * 0.075) * 100).toInt()
        }
        else -> 0
    }