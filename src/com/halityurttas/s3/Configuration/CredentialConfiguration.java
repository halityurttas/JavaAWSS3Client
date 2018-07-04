/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halityurttas.s3.Configuration;

import com.amazonaws.auth.AWSCredentials;

/**
 *
 * @author halit
 */
public class CredentialConfiguration implements AWSCredentials {

    private final String _AWSAccessKeyId;
    private final String _AWSSecretKey;
    
    public CredentialConfiguration(String AWSAccessKeyId, String AWSSecretKey) {
        _AWSAccessKeyId = AWSAccessKeyId;
        _AWSSecretKey = AWSSecretKey;
    }
    
    @Override
    public String getAWSAccessKeyId() {
        return this._AWSAccessKeyId;
    }

    @Override
    public String getAWSSecretKey() {
        return this._AWSSecretKey;
    }
    
}
