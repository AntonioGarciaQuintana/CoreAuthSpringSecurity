package com.controller;

import com.entities.Contact;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by fagarcia on 06/10/2018.
 */
@RestController
@RequestMapping("contact")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    ContactService contactService;

    /**
     * Metodo del controller para consultar todos lod registros de contacto
     * @return una list de todos los contactos
     */
    @GetMapping(path = "/all")
    public ResponseEntity getContacts() {
        List<Contact> contacts = this.contactService.getAll();
        return ResponseEntity.ok().body(contacts);
    }

    /**
     * Metodo del controller para paginar los registros de contacto
     * @param pageable indica cual será el cantidad de registros y el sorting por pagina
     * @return
     */
    @GetMapping(path = "/getPage")
    public ResponseEntity getPage(Pageable pageable) {
        Page<Contact> contacts = this.contactService.getPage(pageable);
        return ResponseEntity.ok().body(contacts);
    }

    /**
     * Metodo del controller para guardar y actualizar el contacto
     * @param contact objeto de contacto que se guardará o actualizará
     * @return
     */
    @PostMapping(path = "/saveContact")
    public ResponseEntity saveContact( @RequestBody Contact contact ){
    Contact ret = this.contactService.saveOrUpdateContact(contact);
    return  ResponseEntity.ok().body(ret);
    }

    /**
     * Metodo del controller para eliminar el contacto
     * @param id de contacto  que se eliminará
     * @return
     */
    @DeleteMapping(value = "/DeleteContact/{id}")
    public  ResponseEntity DeleteContact( @PathVariable("id") long id){
        this.contactService.deleteContact(id);
        return ResponseEntity.ok().body(null);
    }


}
