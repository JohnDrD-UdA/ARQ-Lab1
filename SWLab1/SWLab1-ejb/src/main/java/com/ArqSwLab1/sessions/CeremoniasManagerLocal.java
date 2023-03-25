/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSwLab1.sessions;

import javax.ejb.Local;
import com.ArqSwLab1.entitties.Ceremoniagrados;
import java.util.List;

/**
 *
 * @author John David Rodriguez
 */
@Local
public interface CeremoniasManagerLocal {

    List<Ceremoniagrados> getAllCeremonias();

    Ceremoniagrados update(Ceremoniagrados cereminia);

    Ceremoniagrados create(Ceremoniagrados c);

    boolean delete(Ceremoniagrados ceremonia);
    
}
