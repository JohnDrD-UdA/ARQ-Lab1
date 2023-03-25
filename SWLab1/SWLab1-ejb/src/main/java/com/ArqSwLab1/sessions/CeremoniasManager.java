/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSwLab1.sessions;

import com.ArqSwLab1.entitties.Ceremoniagrados;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author John David Rodriguez
 */
@Stateless
public class CeremoniasManager implements CeremoniasManagerLocal {

    @PersistenceContext(unitName = "com.ArqSwLab1_SWLab1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Override
    public List<Ceremoniagrados> getAllCeremonias() {
        try{
        Query query= em.createNamedQuery("Ceremoniagrados.findAll");
        List<Ceremoniagrados> result= query.getResultList();
        return result;
        }
        catch(Exception e){
            System.out.println("error en listado");
            return new ArrayList() ;
        }

    }

    @Override
    public Ceremoniagrados update(Ceremoniagrados cereminia) {
        return em.merge(cereminia);
    }

    @Override
    public Ceremoniagrados create(Ceremoniagrados c) {
        em.persist(c);
        return c;
    }

    @Override
    public boolean delete(Ceremoniagrados ceremonia) {
        try{
        em.createQuery("delete FROM Ceremoniagrados c where c.ceremoniagradoid=:ceremoniag")
                .setParameter("ceremoniag", ceremonia.getCeremoniagradoid())
                .executeUpdate();
        return true;
        }
        catch(Exception e){
            System.out.println(e.toString());
        return false;}

    }

    public void persist(Object object) {
        try {
            em.persist(object);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    


}
