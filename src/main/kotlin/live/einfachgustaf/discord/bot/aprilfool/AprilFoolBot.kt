package live.einfachgustaf.discord.bot.aprilfool

import dev.kord.core.Kord
import live.einfachgustaf.discord.bot.aprilfool.utils.token

object AprilFoolBot {

    lateinit var kord: Kord

    suspend fun init() {
        kord = Kord(token)

        kord.login()
    }
}