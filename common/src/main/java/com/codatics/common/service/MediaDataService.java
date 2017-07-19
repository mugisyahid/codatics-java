/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codatics.common.service;

/**
 * @author ligar.syahid
 *         <p>
 *         handling media
 */
public interface MediaDataService {

    Object read(Object object);

    Object write(Object object);

    Object download(Object object);

    Object upload(Object object);

    Object delete(Object object);

    Object play(Object object);

    boolean isReadable(Object object);

    boolean isWritable(Object object);

    boolean isDownloadable(Object object);

    boolean isUploadable(Object object);

    boolean isDeletable(Object object);

    boolean isPlayable(Object object);

}
