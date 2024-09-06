package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final Map<Long, Map<Long, Item>> items;
    private final Map<Long, Long> lastUserIds;

    public ItemRepositoryImpl() {
        this.items = new HashMap<>();
        this.lastUserIds = new HashMap<>();
    }

    @Override
    public List<Item> finaByUserId(final long userId) {
        return new ArrayList<>(items.getOrDefault(userId, Collections.emptyMap()).values());
    }

    @Override
    public Item save(final Item item) {
        final long itemId = lastUserIds.merge(item.getUserId(), 1L, Long::sum);
        item.setId(itemId);
        return items.computeIfAbsent(item.getUserId(), key -> new HashMap<>()).put(itemId, item);
    }

    @Override
    public void deleteByUserIdAndItemId(final long userId, final long itemId) {
        Optional.ofNullable(items.get(userId)).ifPresent(i -> i.remove(itemId));
    }
}
