package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Override
    public List<Item> getItems(final long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    @Transactional
    public Item addNewItem(final long userId, final Item itam) {
        itam.setUserId(userId);
        return repository.save(itam);
    }

    @Override
    @Transactional
    public void deleteItem(final long userId, final long id) {
        repository.deleteByUserIdAndId(userId, id);
    }
}
