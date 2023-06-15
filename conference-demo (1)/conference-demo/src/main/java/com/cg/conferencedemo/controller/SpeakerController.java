package com.cg.conferencedemo.controller;

import com.cg.conferencedemo.ResourceNotFoundException;
import com.cg.conferencedemo.model.Session;
import com.cg.conferencedemo.model.Speaker;
import com.cg.conferencedemo.repositories.SessionRepository;
import com.cg.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping("/speaker")
    public List<Speaker> getAllSpeaker(){
        return speakerRepository.findAll();
    }

    @GetMapping("/speaker/{id}")
    public ResponseEntity<Speaker> getSpeakerById(@PathVariable(value = "speaker_id") Long speaker_id)
            throws ResourceNotFoundException {
        Speaker speaker = speakerRepository.findById(speaker_id)
                .orElseThrow(()->new ResourceNotFoundException("Session not found for this id :: " + speaker_id));
        return ResponseEntity.ok().body(speaker);
    }

    @PostMapping("/speakers")
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.save(speaker);
    }

    @DeleteMapping("speaker/delete/{id}") // it is used to delete data into database
    public ResponseEntity<Void> deleteSpeakerById(@PathVariable long speaker_id) {   //it is used to extract the value from the uri
        speakerRepository.deleteById(speaker_id);
        return ResponseEntity.noContent().build();
    }

}
