package com.example.senyumdifabel.timeline;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.following.Following;
import com.example.senyumdifabel.params.TimelineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class TimelineController {
    private TimelineRepository timelineRepository;

    @Autowired
    public TimelineController(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
    }

    @PostMapping("/auth/postTimeline")
    public Timeline postTimeline(@RequestBody Timeline timeline){
        return timelineRepository.save(timeline);
    }

    @GetMapping("/auth/getTimelines")
    public List<Timeline> show(){
        return timelineRepository.findAll();
    }

    @GetMapping("/auth/getTimeline/{id}")
    public Timeline getTimeline(@PathVariable(value = "id") Long id){
        return timelineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
    }

    @GetMapping("/auth/getMyTimeline/{id}")
    public List<TimelineUser> getMyTimeline(@PathVariable(value = "id") Long id){
        List<TimelineUser> x = new ArrayList<>();
        List<Timeline> temp ;
        temp = timelineRepository.findTimeline(id);
        String name = timelineRepository.FindUserName(id);
        String photo = timelineRepository.FindPhoto(id);
        for(int j=0 ;j< temp.size() ; j++)
        {
            TimelineUser timeline = new TimelineUser() ;

            timeline.setComments(timelineRepository.FindCountComment(temp.get(j).getTimeline_id()));
            timeline.setLike(timelineRepository.FindCountLike(temp.get(j).getTimeline_id()));
            timeline.setUser_name(name);
            timeline.setUser_photo(photo);
            timeline.setTimeline_date(temp.get(j).getTimeline_date());
            timeline.setTimeline_time(temp.get(j).getTimeline_time());
            timeline.setTimeline_photo(temp.get(j).getTimeline_photo());
            timeline.setTimeline_description(temp.get(j).getTimeline_description());
            timeline.setTimeline_id(temp.get(j).getTimeline_id());
            timeline.setUser_id(id);

            x.add(timeline);
        }

        return x;
    }

    @GetMapping("/auth/getFollowingTimeline/{id}")
    public List<TimelineUser> getFollowingTimeline(@PathVariable(value = "id") Long id){
        List<Following> Follow  = timelineRepository.findFollowing(id) ;
        List<TimelineUser> timelines= new ArrayList<>();
        for(int i = 0 ; i <= Follow.size() ;i++)
        {
            Long y ;
            if(i<Follow.size())
            {
                y = Follow.get(i).getUser_id();
            }
            else
            {
                y = id ;
            }
            List<Timeline> temp ;
            temp = timelineRepository.findTimeline(y);
            String name = timelineRepository.FindUserName(y);
            String photo = timelineRepository.FindPhoto(y);

            for(int j=0 ;j< temp.size() ; j++)
            {
                TimelineUser timeline = new TimelineUser() ;

                timeline.setComments(timelineRepository.FindCountComment(temp.get(j).getTimeline_id()));
                timeline.setLike(timelineRepository.FindCountLike(temp.get(j).getTimeline_id()));
                timeline.setUser_name(name);
                timeline.setUser_photo(photo);
                timeline.setTimeline_date(temp.get(j).getTimeline_date());
                timeline.setTimeline_time(temp.get(j).getTimeline_time());
                timeline.setTimeline_photo(temp.get(j).getTimeline_photo());
                timeline.setTimeline_description(temp.get(j).getTimeline_description());
                timeline.setTimeline_id(temp.get(j).getTimeline_id());
                timeline.setUser_id(y);

                timelines.add(timeline);
            }
        }
        Collections.sort( timelines , TimelineUser.COMPARE_BY_ID );
        return timelines;
    }

    @DeleteMapping("/auth/deleteTimeline/{id}")
    public boolean deleteTimeline(@PathVariable(value = "id") Long id){
        Timeline timeline = timelineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        timelineRepository.delete(timeline);
        return true;
    }
}