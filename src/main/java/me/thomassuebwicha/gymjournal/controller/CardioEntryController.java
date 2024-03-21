package me.thomassuebwicha.gymjournal.controller;

import me.thomassuebwicha.gymjournal.domain.entities.CardioEntry;
import me.thomassuebwicha.gymjournal.domain.services.CardioEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cardio-entries")
public class CardioEntryController {

    @Autowired
    private CardioEntryService cardioEntryService;

    @GetMapping
    public List<CardioEntry> getAllEntries() {
        return cardioEntryService.getAllEntries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardioEntry> getEntryById(@PathVariable Long id) {
        Optional<CardioEntry> entry = cardioEntryService.getEntryById(id);
        return entry.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CardioEntry> createEntry(@RequestBody CardioEntry entry) {
        CardioEntry savedEntry = cardioEntryService.saveEntry(entry);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardioEntry> updateEntry(@PathVariable Long id, @RequestBody CardioEntry entry) {
        if (cardioEntryService.getEntryById(id).isPresent()) {
            entry.setId(id);
            CardioEntry updatedEntry = cardioEntryService.saveEntry(entry);
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        if (cardioEntryService.getEntryById(id).isPresent()) {
            cardioEntryService.deleteEntry(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}