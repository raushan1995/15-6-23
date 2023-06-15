package com.cg.conferencedemo.repositories;

import com.cg.conferencedemo.model.Speaker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpeakerRepository extends MongoRepository<Speaker, Long> {
}
