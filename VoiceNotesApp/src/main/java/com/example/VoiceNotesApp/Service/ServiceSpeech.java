package com.example.VoiceNotesApp.Service;

import com.example.VoiceNotesApp.Model.ModelSpeech;
import com.example.VoiceNotesApp.Repository.RepoSpeech;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSpeech {
    @Autowired
    private RepoSpeech repoSpeech;

    public String saveToDatabase(String name, String age) {
        ModelSpeech modelSpeech = new ModelSpeech();
        modelSpeech.setName(name);
        modelSpeech.setAge(age);
        repoSpeech.save(modelSpeech);
        return modelSpeech.toString();
    }


}
