package com.fresh.coding.bookverse.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Integer stars;

    @NonNull
    private String commentary;

    @ManyToOne
    @NonNull
    private Book book;
}
