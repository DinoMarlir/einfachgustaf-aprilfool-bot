package live.einfachgustaf.discord.bot.aprilfool.utils

import java.time.LocalDate

fun isAprilFool(): Boolean {
    val today = LocalDate.now()
    return today.monthValue == 4 && today.dayOfMonth == 1
}