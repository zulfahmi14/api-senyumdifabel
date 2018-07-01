package com.example.senyumdifabel.timeline;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.following.Following;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TimelineController {
    private TimelineRepository timelineRepository;



    @Autowired
    public TimelineController(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
    }

    @PostMapping("/postTimeline")
    public Timeline postTimeline(@RequestBody Timeline timeline){
        return timelineRepository.save(timeline);
    }

    @GetMapping("/getTimelines")
    public List<Timeline> show(){
        return timelineRepository.findAll();
    }

    @GetMapping("/getTimeline/{id}")
    public Timeline getTimeline(@PathVariable(value = "id") Long id){
        return timelineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
    }

    @GetMapping("/getMyTimeline/{id}")
    public List<Timeline> getMyTimeline(@PathVariable(value = "id") Long id){
        return timelineRepository.findTimeline(id);
    }

    @GetMapping("/getFollowingTimeline/{id}")
    public List<Timeline> getFollowingTimeline(@PathVariable(value = "id") Long id){
        List<Following> Follow ;
        List<Timeline> timelines= new ArrayList<Timeline>();
        Follow =  timelineRepository.findFollowing(id) ;
        for(int i = 0 ; i < Follow.size() ;i++)
        {
            String x = Follow.get(i).getUser_id();
            Long y = Long.parseLong(x);
            List<Timeline> temp ;
            if(i == 0)
            {
                timelines = timelineRepository.findTimeline(y);
            }
            else
            {
                temp = timelineRepository.findTimeline(y);
                timelines.addAll(temp) ;
            }
        }
        // sortingnya belum..
        return timelines;
    }

    @DeleteMapping("/deleteTimeline/{id}")
    public boolean deleteTimeline(@PathVariable(value = "id") Long id){
        Timeline timeline = timelineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        timelineRepository.delete(timeline);
        return true;
    }


}