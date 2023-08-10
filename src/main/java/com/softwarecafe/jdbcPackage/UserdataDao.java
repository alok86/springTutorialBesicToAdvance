package com.softwarecafe.jdbcPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("edao")
public class UserdataDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveUserdata(Userdata userdata)
    {
        String query = "insert into userdata values('"+userdata.getId()+"','"+userdata.getUsername()+"','"+userdata.getPassword()+"')";
        return jdbcTemplate.update(query);
    }

    public int updateUserdata(Userdata userdata)
    {
        String query ="update userdata set username = '"+userdata.getUsername()+"',password='"+userdata.getPassword()+"'where id ='"+userdata.getId()+"'";
        return jdbcTemplate.update(query);
    }


    // ******************* Using PreparedStatement *****************
    public Boolean deleteUserdata(Userdata userdata)
    {
        //String query="delete from employee where id='"+userdata.getId()+"' ";
        String query = "delete from userdata where id = ?";
        //return jdbcTemplate.update(query);
        return jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) preparedStatement -> {
            preparedStatement.setInt(1,userdata.getId());
            return preparedStatement.execute();
        });
    }

    public List<Userdata> getAllUserData(){
        return jdbcTemplate.query("select * from userdata", new ResultSetExtractor<List<Userdata>>() {
            @Override
            public List<Userdata> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Userdata> list = new ArrayList<>();

                while(resultSet.next()){
                    Userdata e=new Userdata();
                    e.setId(resultSet.getInt(1));
                    e.setUsername(resultSet.getString(2));
                    e.setPassword(resultSet.getString(3));
                    list.add(e);
                }

                return list;
            }
        });
    }

    public List<Userdata> getAllUserRawMapper(){
        return jdbcTemplate.query("select * from userdata", new RowMapper<Userdata>() {
            @Override
            public Userdata mapRow(ResultSet resultSet, int i) throws SQLException {
                Userdata user = new Userdata();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                return user;
            }
        });


    }

    public void saveUserdataAnother(Userdata userdata){
        String query="insert into userdata values (:id,:username,:password)";

        Map<String , Object> map = new HashMap<>();
        map.put("id",userdata.getId());
        map.put("username",userdata.getUsername());
        map.put("password",userdata.getPassword());
        namedParameterJdbcTemplate.execute(query, map, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                return preparedStatement.executeUpdate();
            }
        });
    }


}
