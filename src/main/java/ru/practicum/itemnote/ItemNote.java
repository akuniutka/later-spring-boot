package ru.practicum.itemnote;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.practicum.item.Item;

import java.time.Instant;

@Entity
@Table(name = "item_notes")
@Data
@EqualsAndHashCode(of = "id")
public class ItemNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Instant created = Instant.now();
}
