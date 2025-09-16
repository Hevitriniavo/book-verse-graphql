package com.fresh.coding.bookverse;

import com.fresh.coding.bookverse.entities.*;
import com.fresh.coding.bookverse.repositories.AuthorRepository;
import com.fresh.coding.bookverse.repositories.BookRepository;
import com.fresh.coding.bookverse.repositories.PublisherRepository;
import com.fresh.coding.bookverse.repositories.ReviewRepository;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepo;
    private final PublisherRepository publisherRepo;
    private final BookRepository bookRepo;
    private final ReviewRepository reviewRepo;

    @Override
    @Transactional
    public void run(String... args) {
        if (
                authorRepo.count() == 0 &&
                        publisherRepo.count() == 0 &&
                        bookRepo.count() == 0 &&
                        reviewRepo.count() == 0
        ) {
            var faker = new Faker();

            for (int i = 0; i < 10; i++) {
                var author = authorRepo.save(
                        Author.builder()
                                .name(faker.book().author())
                                .build()
                );
                var publisher = publisherRepo.save(
                        Publisher.builder()
                                .name(faker.book().publisher())
                                .build()
                );

                for (int j = 0; j < 2; j++) {
                    var book = bookRepo.save(
                            Book.builder()
                                    .title(faker.book().title())
                                    .author(author)
                                    .publisher(publisher)
                                    .category(Category.values()[faker.number().numberBetween(0, Category.values().length)])
                                    .build()
                    );

                    for (int k = 0; k < 2; k++) {
                        Review review = reviewRepo.save(
                                Review.builder()
                                        .stars(faker.number().numberBetween(1, 6))
                                        .commentary(faker.lorem().sentence())
                                        .book(book)
                                        .build()
                        );
                        log.info(" Review créée : {} pour le livre '{}'", review.getId(), book.getTitle());
                    }

                    log.info(" Livre créé : '{}' par '{}'", book.getTitle(), author.getName());
                }

                log.info(" Auteur créé : {}", author.getName());
                log.info("Publisher créé : {}", publisher.getName());
            }

            log.info("Données factices générées avec succès !");
        } else {
            log.warn("Les tables contiennent déjà des données, génération ignorée.");
        }
    }
}
