package contact;

import com.CoreApplication;
import com.entities.Contact;
import com.service.ContactService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by fagarcia on 07/10/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class ContactTest {

    @Autowired
    private ContactService contactService;

    /**
     * Prueba para validar el guardado de contato
     */
    @Test
    public void saveContactTest() {
        Contact contact = new Contact("Antonio García Quintana",27,"tony","64-41-02-35-23");
        contact = this.contactService.saveOrUpdateContact(contact);
        Assert.assertTrue(contact.getId() != 0);
    }

    /**
     * Prueba para validar la consulta de contacto por id
     */
    @Test
    public void getContactByIdTest(){
        Contact contact = null;
        contact = this.contactService.getContactById(1L);
        Assert.assertNotNull(contact);
    }

    /**
     * prueba para validar el actualizado del contacto
     */
    @Test
    public void updateContactTest(){
        Contact contact = this.contactService.getContactById(1L);
        Contact ret = null;
        contact.setNickName("tony actualizado");
        ret = this.contactService.saveOrUpdateContact(contact);
        Assert.assertTrue(ret.getNickName().equalsIgnoreCase(contact.getNickName()));
    }

    /**
     * prueba para validar la consulta de todos los registros de contacto
     */
    @Test
    public  void getAllContactsTest(){
        List<Contact> contacts = null;
        contacts = this.contactService.getAll();
        Assert.assertNotNull(contacts);
    }
}
