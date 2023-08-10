package com.softwarecafe.jpaProjections.projectionIntrfaces;

import com.softwarecafe.jpaProjections.model.Department;
import org.springframework.beans.factory.annotation.Value;

public interface ArtisandptInfo {

    // Close projection because it depends upon the entity methods and look for that methods
    String getName();
    int getSalary();
    DeptInfo getDepartment();

    //Projection Using Default Methods
    Department getDepartmentaadata();

    default String getDisplayDataString(){
        return String.format("Name: %s , Dept: %s",getName(),getDepartmentaadata().getDeptName());
    }
    // open projections
    @Value("#{target.name+'('+target.department.deptName+'dept)'}")
    String getDisplayString();

    // Artisandpt: Charlie, Department: IT, NY (output of following expression)
    @Value("#{args[0]+': '+target.name+', '+args[1]+': '+ "
            + "target.department.deptName+', '+target.department.location}")
    String getDetailedString(String labelName,String labelDept);


    interface DeptInfo{
        String getDeptName();
    }
}
