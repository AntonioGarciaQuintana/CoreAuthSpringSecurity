package com.service.Impl;

import com.entities.Contact;
import com.repository.ContactRepository;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fagarcia on 06/10/2018.
 */
@Service
public class ContactServiceImpl implements ContactService {

    ContactRepository contactRepository;

    @Autowired
    ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public Page<Contact> getPage(Pageable pageable) {
        return this.contactRepository.getPage(pageable);
    }

    @Override
    public List<Contact> getAll() {
        return this.contactRepository.getAll();
    }

    @Override
    public Contact saveOrUpdateContact(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(long id) {
        return this.contactRepository.findById(id);
    }

    @Override
    public void deleteContact(long id) {
        this.contactRepository.delete(id);
    }
}
