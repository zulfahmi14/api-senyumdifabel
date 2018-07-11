package com.example.senyumdifabel.params;

import com.example.senyumdifabel.job.Job;

public class JobCompany extends Job {
    protected String company_name;
    protected Long flag_bookmark;  //1 bookmark, 0 non-bookmark
    
    public JobCompany(){}


    public JobCompany(String name, String description, String date, String time, Long company_id, String company_name, Long flag_bookmark) {
        super(name, description, date, time, company_id);
        this.company_name = company_name;
        this.flag_bookmark = flag_bookmark;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    
    public Long getFlag_bookmark(){
        return flag_bookmark;   
    }
    
    public void setFlag_bookmark(Long flag_bookmark){
        this.flag_bookmark = flag_bookmark;   
    }
}
