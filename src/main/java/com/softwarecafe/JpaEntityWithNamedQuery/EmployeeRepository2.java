package com.softwarecafe.JpaEntityWithNamedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository2 extends CrudRepository<Employee5,Long> {
    @Query("SELECT e.dept, MAX(e.salary) FROM Employee5 e GROUP BY e.dept HAVING e.dept in ?1")
    public List<Object[]> findMaxSalariesByDept(List<String> deptName);
    @Query("SELECT e FROM Employee5 e WHERE e.name LIKE ?1")
    public List<Employee5> findByName(String name);
//    will call on service method as like follows
//    repo.findByName("%ana%")
    @Query("SELECT e FROM Employee5 e WHERE e.name LIKE %?1%")
    public List<Employee5> findByName2(String name);
    /*
    * Calling above method: at service method
     repo.findByName2("ana");*/
    public List<Employee5> findByNameContaining(String name);
    /*
    * Calling above method:
    * repo.findByNameContaining("ana");
    * */

    //The @Query annotation can also be used to declare native queries.
    // For that we need to set the @Query#nativeQuery flag to true.
    @Query(value = "SELECT max(avg_sal), min(avg_sal) FROM (SELECT dept , avg(salary) as avg_sal "
            + "from Employee5 GROUP BY dept HAVING dept in ?1) ", nativeQuery = true)
    public Object[][] findMaxMinAvgSalariesOfDept(List<String> deptNames);

    /*
    * calling abaove method as follows
    * System.out.println(" -- finding max/min of average salaries in Admin and IT depts --");
    *    Object[][] maxAvgSalaries = repo.findMaxMinAvgSalariesOfDept(Arrays.asList("Admin", "IT"));
    *    for (Object[] maxAvgSalary : maxAvgSalaries) {
    *    System.out.println("max avg salary: " + maxAvgSalary[0]);
    *   System.out.println("min avg salary: " + maxAvgSalary[0]);
    *   }
    * */

    @Query("SELECT e FROM Employee5 e WHERE e.dept = :dept AND "
            + "(SELECT COUNT(DISTINCT e2.salary) FROM Employee5 e2 "
            + "WHERE e.salary < e2.salary AND e2.dept = :dept) < :topSalNum "
            + "ORDER BY e.salary DESC")
    List<Employee5> findByDeptTopNSalaries(@Param("topSalNum") long topSalaryNum, @Param("dept") String dept);
    /* calling above method as follow
     *   for (int i = 1; i <= 6; i++) {
     *   System.out.printf(" -- finding employees have top %s salaries in IT dept --%n", i);
     *   List<Employee> es = repo.findByDeptTopNSalaries(i, "IT");
     *   es.forEach(System.out::println);
     *   }
     * */

}
