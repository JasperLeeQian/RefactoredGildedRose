package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case ItemConstants.AGED_BRIE:
                    updateAgedBrie(item);
                    break;
                case ItemConstants.SULFURAS:
                    // legendary item, never changes
                    break;
                case ItemConstants.BACKSTAGE_PASS:
                    updateBackstagePass(item);
                    break;
                case ItemConstants.CONJURED:
                    updateConjured(item);
                    break;
                default:
                    updateNormalItem(item);
                    break;
            }
        }
    }

    private void updateItem(Item item, int qualityChange) {
        decrementSellIn(item);
        item.quality = Math.min(50, Math.max(0, item.quality + qualityChange));
    }

    private void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateNormalItem(Item item) {
        int change = item.sellIn <= 0 ? -2 : -1;
        updateItem(item, change);
    }

    private void updateAgedBrie(Item item) {
        int change = item.sellIn <= 0 ? 2 : 1;
        updateItem(item, change);
    }

    private void updateBackstagePass(Item item) {
        if (item.sellIn <= 0) {
            decrementSellIn(item);
            item.quality = 0;
            return;
        }
        int change = item.sellIn <= 5 ? 3 : item.sellIn <= 10 ? 2 : 1;
        updateItem(item, change);
    }

    private void updateConjured(Item item) {
        int change = item.sellIn <= 0 ? -4 : -2;
        updateItem(item, change);
    }
}

