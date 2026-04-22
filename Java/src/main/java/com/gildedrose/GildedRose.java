package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.model.ItemConstants;
import com.gildedrose.service.ItemUpdater;
import com.gildedrose.service.updater.*;

import java.util.Map;

class GildedRose {
    Item[] items;

    private static final Map<String, ItemUpdater> updaters = Map.of(
        ItemConstants.AGED_BRIE, new AgedBrieUpdater(),
        ItemConstants.SULFURAS, new SulfurasUpdater(),
        ItemConstants.BACKSTAGE_PASS, new BackstagePassUpdater(),
        ItemConstants.CONJURED, new ConjuredUpdater(),
        ItemConstants.ITEM_X, new NewItemXUpdater()
    );

    private static final ItemUpdater defaultUpdater = new NormalItemUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updaters.getOrDefault(item.name, defaultUpdater).update(item);
        }
    }
}

