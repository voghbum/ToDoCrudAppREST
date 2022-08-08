package com.voghbum.ToDoCrudAppOneToMany.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    public long id;

    @Column(name = "text", length = 512)
    public String text;

    @Column(name = "insert_time", nullable = false)
    public LocalDateTime insertTime = LocalDateTime.now();

    @Column(name = "last_update", nullable = false)
    public LocalDateTime lastUpdate = insertTime;

    @Column(name = "completed", nullable = false)
    public boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    public Todo todo;

    @Transient
    public long todoId;
}
