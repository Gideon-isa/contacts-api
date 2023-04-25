package com.ltp.contacts.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.contacts.exception.NoContactException;
import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    
    @Override
    public Contact getContactById(String id) throws NoContactException{
        // TODO Auto-generated method stub
        return contactRepository.getContact(findIndexById(id));
       // throw new UnsupportedOperationException("Unimplemented method 'getContactById'");
    }
    
    
    
    
    private int findIndexById(String id) throws NoContactException {
        return IntStream.range(0, contactRepository.getContacts().size())
        .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new NoContactException());
        }




    @Override
    public void saveContact(Contact contact) {
        // TODO Auto-generated method stub
        contactRepository.saveContact(contact);
        //throw new UnsupportedOperationException("Unimplemented method 'saveContact'");
    }




    @Override
    public void updateContact(String id, Contact contact) throws NoContactException{
        // TODO Auto-generated method stub
        contactRepository.updateContact(findIndexById(id), contact);
    }




    @Override
    public void deleteContact(String id) throws NoContactException{
        // TODO Auto-generated method stub
        contactRepository.deleteContact(findIndexById(id));
    }




    @Override
    public List<Contact> getContacts() {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getContacts'");
       return contactRepository.getContacts();
    }

    
        

        
        
        
    }
    