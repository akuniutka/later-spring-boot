package ru.practicum.note;

import java.util.List;

public interface ItemNoteService {

    ItemNote addNewNote(long userId, ItemNote itemNote);

    List<ItemNote> getItemNotes(long userId, int page, int size);

    List<ItemNote> searchNotesByUrl(long userId, String urlPattern);

    List<ItemNote> searchNotesByTag(long userId, String tag);
}
