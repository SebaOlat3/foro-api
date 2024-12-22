package com.foro.controller;

import com.foro.model.Topic;
import com.foro.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        return topicRepository.save(topic);
    }

    @DeleteMapping("/{id}")
    public String deleteTopic(@PathVariable Long id) {
        topicRepository.deleteById(id);
        return "Tópico eliminado con éxito.";
    }
}
