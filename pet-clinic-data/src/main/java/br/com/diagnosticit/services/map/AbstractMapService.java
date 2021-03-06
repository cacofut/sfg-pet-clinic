/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.services.map;

import br.com.diagnosticit.model.BaseEntity;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author cristiano
 */
public class AbstractMapService<T extends BaseEntity, ID extends Long>{
    
    protected Map<Long, T> map = new HashMap<>();
    
    Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    
    T findById( ID id ){
        return map.get(id);
    }
    
    T save( T object ){
        
        if( object != null ){
            if( object.getId() == null ){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        
        return object;
    }
    
    void deleteById( ID id ){
        map.remove(id);
    }
    
    void delete( T object ){
        map.entrySet().removeIf( entry -> entry.getValue().equals(object));
    }
    
    private Long getNextId(){
        
        Long nextId = null;
        try{
            nextId = Collections.max( map.keySet()) + 1;
        }
        catch( NoSuchElementException ex ){
            nextId = 1L;
        }
        return nextId;
    }
}
