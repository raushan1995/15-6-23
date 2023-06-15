package com.cg.conferencedemo.repositories;

import com.cg.conferencedemo.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
