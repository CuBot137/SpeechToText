package com.example.VoiceNotesApp.Controller;

import com.example.VoiceNotesApp.Service.ServiceSpeech;
import com.theokanning.openai.audio.CreateTranscriptionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
public class ControllerSpeech {

    @Autowired
    private ServiceSpeech serviceSpeech;

    @Value("${openai.api.key}")
    private String apiKey;

    @GetMapping("/audio")
    public String audio(@RequestParam String filepath) {
        OpenAiService service = new OpenAiService(apiKey);

        CreateTranscriptionRequest request = new CreateTranscriptionRequest();
        request.setModel("whisper-1");
        File file = new File(filepath);
        String transcription = service.createTranscription(request, filepath).getText();
        return transcription;
    }




    }



















    // Save information from the form to the database
//    @PostMapping("/save")
//    public String saveToDatabase(@RequestParam String name, @RequestParam String age, Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("age", age);
//        serviceSpeech.saveToDatabase(name, age);
//        return "test"; // HTML page
//    }
//
//    // Opens the webpage
//    @GetMapping("/test")
//    private String test(){
//        return "test";
//    }

