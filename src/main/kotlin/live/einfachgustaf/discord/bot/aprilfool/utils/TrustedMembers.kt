package live.einfachgustaf.discord.bot.aprilfool.utils

import dev.kord.common.entity.Snowflake

val trustedMembers = System.getenv().filter { it.key.startsWith("TRUSTED_MEMBER_") }.values.map { Snowflake(it.toLong()) } //jo XD