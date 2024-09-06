package ru.practicum.item;

import java.util.List;

public interface ItemService {

    List<Item> getItems(long userId);

    Item addNewItem(long userId, Item itam);

    void deleteItem(long userId, long itemId);
}
