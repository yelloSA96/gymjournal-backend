package me.thomassuebwicha.gymjournal.domain.services;

import me.thomassuebwicha.gymjournal.dao.WeightEntryRepository;
import me.thomassuebwicha.gymjournal.domain.entities.WeightEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeightEntryService {

    @Autowired
    private WeightEntryRepository weightEntryRepository;

    public List<WeightEntry> getAllEntries() {
        return weightEntryRepository.findAll();
    }

    public Optional<WeightEntry> getEntryById(Long id) {
        return weightEntryRepository.findById(id);
    }

    public WeightEntry saveEntry(WeightEntry entry) {
        return weightEntryRepository.save(entry);
    }

    public void deleteEntry(Long id) {
        weightEntryRepository.deleteById(id);
    }
}
