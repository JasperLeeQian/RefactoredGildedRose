package com.gildedrose.service.updater;

import com.gildedrose.model.Item;
import com.gildedrose.service.BaseItemUpdater;

public class NewItemXUpdater extends BaseItemUpdater {
    public void update(Item item) {
        int change = item.sellIn <= 0 ? -5 : -1;
        updateItem(item, change);
    }
}
