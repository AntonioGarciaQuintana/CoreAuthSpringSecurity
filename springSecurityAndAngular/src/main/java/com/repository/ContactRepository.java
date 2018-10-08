package com.repository;

import com.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by fagarcia on 06/10/2018.
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

    @Query("SELECT c FROM Contact c")
    Page<Contact> getPage (Pageable pageable);

    @Query("SELECT c FROM Contact c")
    List<Contact> getAll();

    Contact findById(long id);

}
