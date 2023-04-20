package com.istad.springthymleaf.service.serviceImpl;

import com.istad.springthymleaf.model.Author;
import com.istad.springthymleaf.repository.AuthorRepository;
import com.istad.springthymleaf.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    AuthorServiceImpl(){
        authorRepository = new AuthorRepository();
    }
    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.getAllAuthors();
    }
}
