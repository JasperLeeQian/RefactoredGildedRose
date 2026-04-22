package com.gildedrose.service.updater;

import com.gildedrose.model.Item;
import com.gildedrose.service.BaseItemUpdater;

public class AgedBrieUpdater extends BaseItemUpdater {
    public void update(Item item) {
        int change = item.sellIn <= 0 ? 2 : 1;
        updateItem(item, change);
    }
}

