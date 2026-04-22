package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.model.ItemConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItemDegradesByOneBeforeSellDate() {
        Item[] items = new Item[]{new Item(ItemConstants.NORMAL_ITEM, 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void itemQualityNeverNegative() {
        Item[] items = new Item[]{new Item(ItemConstants.NORMAL_ITEM, 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality); // quality started at 0, should stay 0
    }

    @Test
    void legendarySulfuras() {
        Item[] items = new Item[]{new Item(ItemConstants.SULFURAS, 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void qualityNeverExceeds50() {
        Item[] items = new Item[]{new Item(ItemConstants.AGED_BRIE, 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality); // wants to increase but can't go above 50
    }

    @Test
    void normalItemAfterConcert() {
        Item[] items = new Item[]{new Item(ItemConstants.NORMAL_ITEM, 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, items[0].quality);
    }

    @Test
    void agedBrieBeforeConcert() {
        Item[] items = new Item[]{new Item(ItemConstants.AGED_BRIE, 20, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, items[0].quality);
    }

    @Test
    void agedBrieAfterConcert() {
        Item[] items = new Item[]{new Item(ItemConstants.AGED_BRIE, 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, items[0].quality);
    }

    @Test
    void backstagePassSellIn20Days() {
        Item[] items = new Item[]{new Item(ItemConstants.BACKSTAGE_PASS, 20, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, items[0].quality);
    }

    @Test
    void backstagePassSellIn10Days() {
        Item[] items = new Item[]{new Item(ItemConstants.BACKSTAGE_PASS, 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, items[0].quality);
    }

    @Test
    void backstagePassSellIn5Days() {
        Item[] items = new Item[]{new Item(ItemConstants.BACKSTAGE_PASS, 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, items[0].quality);
    }

    @Test
    void backstagePassAfterConcert() {
        Item[] items = new Item[]{new Item(ItemConstants.BACKSTAGE_PASS, 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void conjuredDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Item(ItemConstants.CONJURED, 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, items[0].quality); // drops by 2 instead of 1
    }

    @Test
    void itemXDegrades5TimesAsFastAfterSellDate() {
        Item[] items = new Item[]{new Item(ItemConstants.ITEM_X, 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15, items[0].quality); // drops by 5 instead of 1
    }

    @Test
    void itemXDegradesByOneBeforeSellDate() {
        Item[] items = new Item[]{new Item(ItemConstants.ITEM_X, 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }
}
