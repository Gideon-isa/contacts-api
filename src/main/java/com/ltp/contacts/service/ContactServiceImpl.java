package com.ltp.contacts.service;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    
    @Override
    public Contact getContactById(String id) {
        // TODO Auto-generated method stub
        return contactRepository.getContact(findIndexById(id));
       // throw new UnsupportedOperationException("Unimplemented method 'getContactById'");
    }
    
    
    
    
    private int findIndexById(String id) {
        return IntStream.range(0, contactRepository.getContacts().size())
        .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
        .findFirst()
            .orElseThrow();
        }




    @Override
    public void saveContact(Contact contact) {
        // TODO Auto-generated method stub
        contactRepository.saveContact(contact);
        //throw new UnsupportedOperationException("Unimplemented method 'saveContact'");
    }




    @Override
    public void updateContact(String id, Contact contact) {
        // TODO Auto-generated method stub
        contactRepository.updateContact(findIndexById(id), contact);
    }

    
        

        
        
        
    }
    