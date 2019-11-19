package com.divae.sk.springboot2.jdbc;

import com.divae.sk.springboot2.author.Author;
import com.divae.sk.springboot2.author.AuthorRepository;
import com.divae.sk.springboot2.publisher.Publisher;
import com.divae.sk.springboot2.publisher.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Repository
public class ComplexQueryRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public List<Publisher> getPublishersForAuthorId(final Long authorId){

        List<Long> publisherIds = jdbcTemplate.queryForList("" +
                "SELECT b.PUBLISHER_ID " +                      // wenn IntelliJ SQL-Fehler anzeigt -> passenden Dialekt einstellen
                "FROM AUTHOR a, AUTHOR_BOOKS ab, BOOK b " +
                "WHERE   a.ID = ab.AUTHOR_ID and " +
                        "ab.BOOKS_ISBN = b.ISBN and " +
                        "a.id = ?", new Object[]{authorId}, Long.class);

        return publisherRepository.findAllByIdIn(publisherIds);
    }

    public List<Author> getAuthorsForPublisherId(final Long publisherId){
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("publisherId", publisherId);
        System.out.println("PARAMETER MAP: " + parameterMap);
        List<Long> authorIds = namedParameterJdbcTemplate.queryForList("" +
                "SELECT DISTINCT ab.AUTHOR_ID " +
                        "FROM PUBLISHER p, BOOK b, AUTHOR_BOOKS ab " +
                        "WHERE p.ID = b.PUBLISHER_ID and " +
                        "b.ISBN = ab.BOOKS_ISBN and " +
                        "ab.AUTHOR_ID = :publisherId",
                parameterMap, Long.class);

        return authorRepository.findAllByIdIn(authorIds);
    }
}
