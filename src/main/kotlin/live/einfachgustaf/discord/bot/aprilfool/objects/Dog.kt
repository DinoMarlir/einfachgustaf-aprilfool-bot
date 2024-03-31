package live.einfachgustaf.discord.bot.aprilfool.objects

import live.einfachgustaf.discord.bot.aprilfool.AprilFoolBot.kord
import live.einfachgustaf.discord.bot.aprilfool.types.DogState

class Dog {
    private var state = DogState.SITTING

    suspend fun setState(value: DogState) {
        kord.editPresence {
            state = value.stateName
        }
        state = value
    }

    fun getState() = state
}