package live.einfachgustaf.discord.bot.aprilfool.listener

import dev.kord.core.behavior.channel.MessageChannelBehavior
import dev.kord.core.entity.User
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import live.einfachgustaf.discord.bot.aprilfool.AprilFoolBot.dog
import live.einfachgustaf.discord.bot.aprilfool.AprilFoolBot.kord
import live.einfachgustaf.discord.bot.aprilfool.types.DogState
import live.einfachgustaf.discord.bot.aprilfool.utils.isAprilFool
import live.einfachgustaf.discord.bot.aprilfool.utils.trustedMembers
import kotlin.random.Random

object MessageCreateListener {

    val messageEvents = hashMapOf(
        "aus" to ::aus,
        "sitz" to ::sitz,
        "steh" to ::steh,
        "beiß" to ::beiss,
        "iss" to ::iss
    )

    init {
        kord.on<MessageCreateEvent> {
            if (!isAprilFool()) {
                println("it's not the 1st april!")
                return@on
            }

            val messageContent = message.content
            val author = message.author

            if (author?.isBot != false) return@on
            if (!trustedMembers.contains(member?.id)) {
                message.channel.createMessage("Du hast mir nix zu sagen!")
                beiss(messageContent, author, message.channel)
                return@on
            }
            if (!messageEvents.containsKey(messageContent.lowercase())) return@on

            val method = messageEvents[messageContent.lowercase()]!!

            method.invoke(messageContent, author, message.channel)
        }

        kord.on<MessageCreateEvent> {
            if (!isAprilFool()) {
                println("it's not the 1st april!")
                return@on
            }

            val author = message.author
            if (author?.isBot != false) return@on

            val randomValue = Random.nextDouble()

            if (randomValue < 0.08) {
                message.channel.createMessage("${message.author?.mention} wird gebissen!")
                beiss(message.content, author, message.channel)
            } else return@on
        }
    }

    suspend fun aus(message: String, author: User, channel: MessageChannelBehavior) {
        steh(message, author, channel)
    }

    @Suppress("UNUSED_PARAMETER")
    suspend fun sitz(message: String, author: User, channel: MessageChannelBehavior) {
        channel.createMessage("Ok! :service_dog:")
        dog.setState(DogState.SITTING)
    }

    @Suppress("UNUSED_PARAMETER")
    suspend fun steh(message: String, author: User, channel: MessageChannelBehavior) {
        channel.createMessage("Ok! :guide_dog:")
        dog.setState(DogState.STANDING)
    }

    @Suppress("UNUSED_PARAMETER")
    suspend fun beiss(message: String, author: User, channel: MessageChannelBehavior) {
        dog.setState(DogState.BITING)
        channel.createMessage(":tooth::tooth::tooth:")
    }

    @Suppress("UNUSED_PARAMETER")
    suspend fun iss(message: String, author: User, channel: MessageChannelBehavior) {
        channel.createMessage("Danke! :heart:")
        dog.setState(DogState.STANDING)
    }
}