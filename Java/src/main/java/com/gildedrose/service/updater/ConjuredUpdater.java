package com.gildedrose.service.updater;

import com.gildedrose.model.Item;
import com.gildedrose.service.BaseItemUpdater;

public class ConjuredUpdater extends BaseItemUpdater {
    public void update(Item item) {
        int change = item.sellIn <= 0 ? -4 : -2;
        updateItem(item, change);
    }
}
