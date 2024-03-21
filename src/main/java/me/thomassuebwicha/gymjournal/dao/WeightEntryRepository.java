package me.thomassuebwicha.gymjournal.dao;

import me.thomassuebwicha.gymjournal.domain.entities.WeightEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightEntryRepository extends JpaRepository<WeightEntry, Long> {
}
