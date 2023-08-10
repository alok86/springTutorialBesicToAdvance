package com.softwarecafe.jpaProjections.projectionIntrfaces;

import org.springframework.beans.factory.annotation.Value;

public interface ArtisandptBeanInfo {
    @Value("#{@artisanInfoBean.getArtisanDisplayString(target)}")
    String getDisplayString() ;

    @Value("#{@artisanInfoBean.getArtisanDetailedString(target,args[0],args[1])}")
    String getDetailedString(String labelName,String labelDept);
}
