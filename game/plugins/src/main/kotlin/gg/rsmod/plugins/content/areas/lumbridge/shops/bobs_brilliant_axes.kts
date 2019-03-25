package gg.rsmod.plugins.content.areas.lumbridge.shops

import gg.rsmod.plugins.content.mechanics.shops.CoinCurrency

create_shop("Bob's Brilliant Axes", CoinCurrency()) {
    items[0] = ShopItem(Items.BRONZE_PICKAXE, 5)
    items[1] = ShopItem(Items.BRONZE_AXE, 10)
    items[2] = ShopItem(Items.IRON_AXE, 5)
    items[3] = ShopItem(Items.STEEL_AXE, 3)
    items[4] = ShopItem(Items.IRON_BATTLEAXE, 5)
    items[5] = ShopItem(Items.STEEL_BATTLEAXE, 2)
    items[6] = ShopItem(Items.MITHRIL_BATTLEAXE, 1)
}
