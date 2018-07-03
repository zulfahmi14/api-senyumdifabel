package com.example.senyumdifabel.notification;

import com.example.senyumdifabel.params.getNotification;
import com.example.senyumdifabel.proposal.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NotificationController {
    private NotificationRepository notificationRepository ;

    @Autowired
    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @PostMapping("/pushNotification/comment")
    public Notification pushNotificationComment(@RequestBody Notification notification){
        notification.setType(4L);
        return notificationRepository.save(notification);
    }

    @PostMapping("/pushNotification/like")
    public Notification pushNotificationLike(@RequestBody Notification notification){
        notification.setType(3L);
        return notificationRepository.save(notification);
    }

    @PostMapping("/pushNotification/follow")
    public Notification pushNotificationFollow(@RequestBody Notification notification){
        notification.setType(2L);
        return notificationRepository.save(notification);
    }

    @PostMapping("/pushNotification/Proposal")
    public Notification pushNotificationProposal(@RequestBody Notification notification){
        notification.setType(1L);
        return notificationRepository.save(notification);
    }

    @GetMapping("/getuser/{id}")
    public List<getNotification> getuser(@PathVariable(value = "id") Long id){
        List<getNotification> getnotif = new ArrayList<>() ;
        List<Notification> x = notificationRepository.findbyEnable(id,false);
        for( int i=0 ; i< x.size() ; i++ )
        {
            // update enable
            x.get(i).setEnable(true);
            notificationRepository.save(x.get(i));

            // variable parent
            getNotification temp = new getNotification() ;
            temp.setData_id(x.get(i).getData_id());
            temp.setEnable(true);
            temp.setId(x.get(i).getId());
            temp.setType(x.get(i).getType());
            temp.setUser_id(x.get(i).getUser_id());

            if(x.get(i).getType() == 1)
            {
                Proposal pro = notificationRepository.findProposal(x.get(i).getData_id()) ;

                temp.setNotif_name(notificationRepository.findCompanyName(pro.getCompany_id())) ; // company name
                temp.setNotif_photo(notificationRepository.findCompanyPhoto(pro.getCompany_id())); // company photo
                temp.setStatus(pro.getStatus()); // status job
                temp.setForward_id(pro.getJob_id()); // id job
                temp.setNotif_detail(notificationRepository.findJobName(x.get(i).getData_id())); // job name from job_id
            }
            else if(x.get(i).getType() == 2)
            {
                
            }
            else if(x.get(i).getType() == 3)
            {

            }
            else {

            }
        }


        return getnotif ;
    }
}
/*
 type :
 proposal/1
 follow/2
 like/3
 comment/4


 */