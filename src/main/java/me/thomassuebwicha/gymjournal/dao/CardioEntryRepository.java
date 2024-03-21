package me.thomassuebwicha.gymjournal.dao;

import me.thomassuebwicha.gymjournal.domain.entities.CardioEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardioEntryRepository extends JpaRepository<CardioEntry, Long> {
}