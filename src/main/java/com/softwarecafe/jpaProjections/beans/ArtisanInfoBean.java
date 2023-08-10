package com.softwarecafe.jpaProjections.beans;

import com.softwarecafe.jpaProjections.model.Artisandpt;
import org.springframework.stereotype.Component;

@Component
public class ArtisanInfoBean {
    public String getArtisanDisplayString(Artisandpt artisandpt){
        return String.format("%s (%S)",artisandpt.getName() , artisandpt.getDepartment().getDeptName());
    }

    public String getArtisanDetailedString(Artisandpt artisandpt,String labelName,String labelDept){
        return String.format("%s : %s , %s : %s , %s",labelName , artisandpt.getName(),
                labelDept , artisandpt.getDepartment().getDeptName() ,
                artisandpt.getDepartment().getLocation());
    }
}
