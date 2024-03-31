package live.einfachgustaf.discord.bot.aprilfool

import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import live.einfachgustaf.discord.bot.aprilfool.listener.MessageCreateListener
import live.einfachgustaf.discord.bot.aprilfool.objects.Dog
import live.einfachgustaf.discord.bot.aprilfool.utils.token

object AprilFoolBot {

    lateinit var kord: Kord
    val dog = Dog()

    suspend fun init() {
        kord = Kord(token)

        MessageCreateListener

        kord.login {
            @OptIn(PrivilegedIntent::class)
            intents += Intent.MessageContent
        }
    }
}