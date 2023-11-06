package com.example.VoiceNotesApp.Controller;

import com.example.VoiceNotesApp.Audio.AudioRecorder;
import com.example.VoiceNotesApp.Service.ServiceSpeech;
import com.theokanning.openai.audio.CreateTranscriptionRequest;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
public class ControllerSpeech {

    @Autowired
    private ServiceSpeech serviceSpeech;

    @Autowired
    private AudioRecorder audioRecorder;

    @Value("${openai.api.key}")
    private String apiKey;

    @GetMapping("/audio")
    public String audio(Model model) {
        OpenAiService service = new OpenAiService(apiKey);
        File file = new File(audioRecorder.Record());
        CreateTranscriptionRequest request = new CreateTranscriptionRequest();
        request.setModel("whisper-1");
        String transcription = service.createTranscription(request, file.getAbsolutePath()).getText();
        model.addAttribute("trans", transcription);
        return "test";
    }


    @GetMapping("/record")
    public ResponseEntity<String> recordedAudio() {
        audioRecorder.Record();
        return new ResponseEntity<>("Recording completed", HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }


    @GetMapping("/getChat/{prompt}")
    public CompletionResult getPrompt(@PathVariable String prompt) {
        OpenAiService service = new OpenAiService("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");
        CompletionRequest completionRequest = CompletionRequest.builder().prompt(prompt).model("gpt-3.5-turbo-instruct").echo(true).build();
        return service.createCompletion(completionRequest);
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

