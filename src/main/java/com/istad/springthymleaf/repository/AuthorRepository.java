package com.istad.springthymleaf.repository;

import com.istad.springthymleaf.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
   private List<Author> authors = new ArrayList<>(){{
        add(new Author(1001,"James","male","nothing last forever"));
       add(new Author(1002,"John","male","nothing last forever"));
       add(new Author(1003,"Moka","Female","nothing last forever"));
       add(new Author(1004,"Lisa","Female","nothing last forever"));
    }};

    public List<Author> getAllAuthors(){
        return authors;
    }
}
