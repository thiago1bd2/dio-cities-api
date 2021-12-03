package com.github.thiago1bd2.citiesapi.countries;

import com.github.thiago1bd2.citiesapi.countries.Country;
import com.github.thiago1bd2.citiesapi.countries.repository.CuntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")
public class CountryResource {
    @Autowired
    private CuntryRepository repository;

    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCountryById(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);
        if (optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }

        return ResponseEntity.notFound().build();
    }
}
