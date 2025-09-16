package com.fresh.coding.bookverse.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NonNull
    private String title;

    @ManyToOne(optional = false)
    @NonNull
    private Author author;

    @ManyToOne
    private Publisher publisher;

    @Enumerated(EnumType.STRING)
    @NonNull
    private Category category;

    @OneToMany
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}
