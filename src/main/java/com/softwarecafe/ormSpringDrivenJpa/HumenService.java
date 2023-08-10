package com.softwarecafe.ormSpringDrivenJpa;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumenService {

    @Autowired
    private Dao<Humen> dao;

    @Transactional
    public void saveHumen(Humen humen)
    {
        try{
            dao.save(humen);
        }catch (DataAccessException e){
            e.printStackTrace();
        }
    }

    @Transactional
    public List<Humen> getAllHumens(){
        try{
            return dao.loadAll();
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public Humen getHumenById(long id)
    {
        try{
            return dao.load(id);
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public void deleteHumen(long id)
    {
        try{
            dao.delete(id);
        }catch (DataAccessException e){
            e.printStackTrace();
        }

    }
    @Transactional
    public void updateHumen(Humen humen)
    {
        try{
            dao.update(humen);
        }catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void clearTable()
    {
        try{
            dao.deleteAll();
        }catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

}
