arrayOf(Npcs.BOB).forEach { shop ->
    on_npc_option(npc = shop, option = "talk-to") {
        player.queue { mainDialog(this) }
    }

    on_npc_option(npc = shop, option = "trade") {
        player.queue { open_shop(this) }
    }

    on_npc_option(npc = shop, option = "repair") {
        // TO DO
    }
}

suspend fun mainDialog(it: QueueTask) {
    //it.chatNpc("Can I help you at all?", animation = 567)
    when (it.options("Give me a quest!", "Have you anything to sell?", "Can you repair my items for me?")) {
        1 -> bobQuest(it)
        2 -> open_shop(it)
        3 -> null
    }
}

suspend fun open_shop(it: QueueTask) {
    it.chatPlayer("Do you have anything to sell?", animation = 588)
    it.chatNpc("Yes! I buy and sell axes! Take your pick (or axe)!", animation = 588) // Fix animation
    it.player.openShop("Bob's Brilliant Axes")
}

suspend fun bobQuest(it: QueueTask) {
    it.chatPlayer("Give me a quest!", animation = 588)
    it.chatNpc("Get yer own!")
}