package com.example.senyumdifabel.params;

import com.example.senyumdifabel.job.Job;

public class JobCompany extends Job {
    protected String company_name;

    public JobCompany(){}


    public JobCompany(String name, String description, String date, String time, Long company_id, String company_name) {
        super(name, description, date, time, company_id);
        this.company_name = company_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
