package com.example.senyumdifabel.timeline;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimelineController {
    private TimelineRepository timelineRepository;



    @Autowired
    public TimelineController(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
    }

    @PostMapping("/posttimeline")
    public Timeline posttimeline(@RequestBody Timeline timeline){
        return timelineRepository.save(timeline);
    }

    @GetMapping("/gettimelines")
    public List<Timeline> show(){
        return timelineRepository.findAll();
    }

    @GetMapping("/gettimeline/{id}")
    public Timeline gettimeline(@PathVariable(value = "id") Long id){
        return timelineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
    }

    @DeleteMapping("/deletetimeline/{id}")
    public boolean deletetimeline(@PathVariable(value = "id") Long id){
        Timeline timeline = timelineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        timelineRepository.delete(timeline);
        return true;
    }


}