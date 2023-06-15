package com.cg.conferencedemo.controller;

import com.cg.conferencedemo.ResourceNotFoundException;
import com.cg.conferencedemo.model.Session;
import com.cg.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/session")
    public List<Session> getAllSession(){
        return sessionRepository.findAll();
    }

    @GetMapping("/session/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable(value = "session_id") Long session_id)
        throws ResourceNotFoundException {
            Session session = sessionRepository.findById(session_id)
                    .orElseThrow(()->new ResourceNotFoundException("Session not found for this id :: " + session_id));
            return ResponseEntity.ok().body(session);
    }

    @PostMapping("/sessions")
    public Session create(@RequestBody final Session session){
        return sessionRepository.save(session);
    }

    @DeleteMapping("session/delete/{id}") // it is used to delete data into database
    public ResponseEntity<Void> deleteSessionById(@PathVariable long session_id) {   //it is used to extract the value from the uri
        sessionRepository.deleteById(session_id);
        return ResponseEntity.noContent().build();
    }



}
