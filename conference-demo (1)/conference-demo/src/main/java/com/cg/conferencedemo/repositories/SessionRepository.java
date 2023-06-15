package com.cg.conferencedemo.repositories;

import com.cg.conferencedemo.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<Session, Long> {
}
