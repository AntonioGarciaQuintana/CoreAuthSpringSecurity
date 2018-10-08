package com.service;

import com.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fagarcia on 06/10/2018.
 */
@Service
public interface ContactService {

    Page<Contact> getPage(Pageable pageable);

    List<Contact> getAll();

    Contact saveOrUpdateContact(Contact contact);

    Contact getContactById(long id);

    void deleteContact(long id);

}
