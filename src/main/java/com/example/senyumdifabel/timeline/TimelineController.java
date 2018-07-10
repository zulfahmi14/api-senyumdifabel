package com.example.senyumdifabel.timeline;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.experience.Experience;
import com.example.senyumdifabel.following.Following;
import com.example.senyumdifabel.params.TimelineUser;
import com.example.senyumdifabel.people.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
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

    @PutMapping("/auth/updateTimeline/{id}") // timeline_id
    public Timeline updateCom(@PathVariable(value = "id") Long id, @RequestBody Timeline peoplenew){
        Timeline peopleold = timelineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setTimeline_description(peoplenew.getTimeline_description());
        peopleold.setTimeline_photo(peoplenew.getTimeline_photo());
        return timelineRepository.save(peopleold);
    }

    @GetMapping("/auth/getMyTimeline/{id}")
    public List<TimelineUser> getMyTimeline(@PathVariable(value = "id") Long id){
        List<TimelineUser> x = new ArrayList<>();
        List<Timeline> temp ;
        temp = timelineRepository.findTimeline(id);
        People people = timelineRepository.FindUser(id);
        int size = people.getExperiences().size() ;
        String job = people.getExperiences().get(size-1).getTitle() ;
        for(int j=0 ;j< temp.size() ; j++)
        {
            TimelineUser timeline = new TimelineUser() ;

            timeline.setComments(timelineRepository.FindCountComment(temp.get(j).getTimeline_id()));
            timeline.setLike(timelineRepository.FindCountLike(temp.get(j).getTimeline_id()));
            timeline.setUser_name(people.getUser_name());
            timeline.setUser_photo(people.getUser_photo());
            timeline.setUser_job(job);
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
            People people = timelineRepository.FindUser(id);
            int size = people.getExperiences().size() ;
            String job = people.getExperiences().get(size-1).getTitle() ;

            for(int j=0 ;j< temp.size() ; j++)
            {
                TimelineUser timeline = new TimelineUser() ;

                timeline.setComments(timelineRepository.FindCountComment(temp.get(j).getTimeline_id()));
                timeline.setLike(timelineRepository.FindCountLike(temp.get(j).getTimeline_id()));
                timeline.setUser_photo(people.getUser_photo());
                timeline.setUser_name(people.getUser_name());
                timeline.setTimeline_date(temp.get(j).getTimeline_date());
                timeline.setTimeline_time(temp.get(j).getTimeline_time());
                timeline.setUser_job(job);
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