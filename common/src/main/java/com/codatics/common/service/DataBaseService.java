/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codatics.common.service;

/**
 *
 * @author ligar.syahid
 */
public interface DataBaseService {

    void approveCreate(Object object);

    void approveUpdate(Object object);

    void approveDelete(Object object);

    void rejected(Object object);

    void stopped(Object object);

    boolean isCreateable(Object object);

    boolean isUpdateable(Object newObject, Object oldObject);

    boolean isDeleteable(Object object);
}
