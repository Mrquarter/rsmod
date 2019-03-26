arrayOf(Npcs.BOB).forEach { shop ->
    on_npc_option(npc = shop, option = "talk-to") {
        player.queue { mainDialog(this) }
    }

    on_npc_option(npc = shop, option = "trade") {
        player.queue { open_shop(this,true) }
    }

    on_npc_option(npc = shop, option = "repair") {
        player.queue { repair_items_quick(this) }
    }
}

suspend fun mainDialog(it: QueueTask) {
    when (it.options("Give me a quest!", "Have you anything to sell?", "Can you repair my items for me?")) {
        1 -> bob_quest(it)
        2 -> open_shop(it, false)
        3 -> repair_items(it)
    }
}

suspend fun open_shop(it: QueueTask, dialog: Boolean) {
    if (dialog) {
        it.chatPlayer("Have you anything to sell?", animation = 588)
        it.chatNpc("Yes! I buy and sell axes! Take your pick (or axe)!", animation = 588) // Fix animation
    }
    it.player.openShop("Bob's Brilliant Axes")
}

suspend fun bob_quest(it: QueueTask) {
    it.chatPlayer("Give me a quest!", animation = 588)
    it.chatNpc("Get yer own!")
}

suspend fun repair_items(it: QueueTask) {
    it.chatPlayer("Can you repair my items for me?", animation = 588)
    it.chatNpc("Of course I'll repair it, though the materials may cost you. Just hand me the item and I'll have a look.")
}

suspend fun repair_items_quick(it: QueueTask) {
    it.chatNpc("You don't have anything I can repair")
    /**
     * To Do
     * Build in repairing items functionality
     */
}