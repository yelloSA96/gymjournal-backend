package me.thomassuebwicha.gymjournal.controller;

import me.thomassuebwicha.gymjournal.domain.entities.WeightEntry;
import me.thomassuebwicha.gymjournal.domain.services.WeightEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/weight-entries")
public class weightEntryController {

    @Autowired
    private WeightEntryService gymEntryService;

    @GetMapping
    public List<WeightEntry> getAllEntries() {
        return gymEntryService.getAllEntries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeightEntry> getEntryById(@PathVariable Long id) {
        Optional<WeightEntry> entry = gymEntryService.getEntryById(id);
        return entry.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<WeightEntry> createEntry(@RequestBody WeightEntry entry) {
        WeightEntry savedEntry = gymEntryService.saveEntry(entry);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeightEntry> updateEntry(@PathVariable Long id, @RequestBody WeightEntry entry) {
        if (gymEntryService.getEntryById(id).isPresent()) {
            entry.setId(id);
            WeightEntry updatedEntry = gymEntryService.saveEntry(entry);
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        if (gymEntryService.getEntryById(id).isPresent()) {
            gymEntryService.deleteEntry(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
