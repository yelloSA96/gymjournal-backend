package me.thomassuebwicha.gymjournal.domain.services;

import me.thomassuebwicha.gymjournal.dao.CardioEntryRepository;
import me.thomassuebwicha.gymjournal.domain.entities.CardioEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardioEntryService {

    @Autowired
    private CardioEntryRepository cardioEntryRepository;

    public List<CardioEntry> getAllEntries() {
        return cardioEntryRepository.findAll();
    }

    public Optional<CardioEntry> getEntryById(Long id) {
        return cardioEntryRepository.findById(id);
    }

    public CardioEntry saveEntry(CardioEntry entry) {
        return cardioEntryRepository.save(entry);
    }

    public void deleteEntry(Long id) {
        cardioEntryRepository.deleteById(id);
    }
}