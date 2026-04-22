package com.gildedrose.service;

import com.gildedrose.model.Item;

public abstract class BaseItemUpdater implements ItemUpdater {
    protected void updateItem(Item item, int qualityChange) {
        item.sellIn--;
        item.quality = Math.min(50, Math.max(0, item.quality + qualityChange));
    }
}
