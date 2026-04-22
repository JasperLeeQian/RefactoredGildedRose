package com.gildedrose.service.updater;

import com.gildedrose.model.Item;
import com.gildedrose.service.BaseItemUpdater;

public class BackstagePassUpdater extends BaseItemUpdater {
    public void update(Item item) {
        if (item.sellIn <= 0) {
            item.sellIn--;
            item.quality = 0;
            return;
        }
        int change = item.sellIn <= 5 ? 3 : item.sellIn <= 10 ? 2 : 1;
        updateItem(item, change);
    }
}
