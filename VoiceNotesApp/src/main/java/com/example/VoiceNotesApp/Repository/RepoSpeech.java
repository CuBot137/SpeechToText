package com.example.VoiceNotesApp.Repository;

import com.example.VoiceNotesApp.Model.ModelSpeech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoSpeech extends JpaRepository<ModelSpeech, Long> {
}
