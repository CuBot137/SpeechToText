package com.example.VoiceNotesApp.Controller;

import com.example.VoiceNotesApp.Service.ServiceSpeech;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerSpeech {

    @Autowired
    private ServiceSpeech serviceSpeech;

    // Save information from the form to the database
    @PostMapping("/save")
    public String saveToDatabase(@RequestParam String name, @RequestParam String age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        serviceSpeech.saveToDatabase(name, age);
        return "test";
    }

    // Opens the webpage
    @GetMapping("/test")
    private String test(){
        return "test";
    }
}
