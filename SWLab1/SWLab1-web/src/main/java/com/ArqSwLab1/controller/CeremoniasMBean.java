/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSwLab1.controller;

import com.ArqSwLab1.sessions.CeremoniasManagerLocal;
import com.ArqSwLab1.entitties.Ceremoniagrados;
import java.util.List;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author John David Rodriguez
 */
public class CeremoniasMBean implements Serializable{

    @EJB
    private CeremoniasManagerLocal ceremoniasManager;
    
    private Ceremoniagrados ceremoniagrados;
    private List<Ceremoniagrados> ceremoniagradoss;
    
    public CeremoniasMBean() {}
    
    public List<Ceremoniagrados> getCeremoniagrados(){
   if((ceremoniagradoss==null)||(ceremoniagradoss.isEmpty()))
       refresh();
       return ceremoniagradoss;
    }
    
    public Ceremoniagrados getDetails(){
        return this.ceremoniagrados;
    }
    
    public String showDetails(Ceremoniagrados ceremonia){
        this.ceremoniagrados=ceremonia;
        return "DETAILS";
    }
    
    public String update(){
        this.ceremoniagrados=this.ceremoniasManager.update(ceremoniagrados);
        return "UPDATE";
    }
    public String create_(){
        this.ceremoniagrados= new Ceremoniagrados();
        return "CREATE";}
    
        public String createNewInstance(){
        this.ceremoniagrados= this.ceremoniasManager.create(ceremoniagrados);
        refresh();
        return "LIST";}
    
    public String delete(){
        this.ceremoniasManager.delete(ceremoniagrados);
        refresh();
        return "DELETED";
    }
    public String list(){
    return"LIST";
    }
    
    
    public void refresh(){
    ceremoniagradoss= ceremoniasManager.getAllCeremonias();
    }


}
