package com.example.ilaboratory.service.impl;

import com.example.ilaboratory.service.Constants;
import org.springframework.stereotype.Service;

@Service("cons")
public class ConstantsImpl implements Constants {
    private int tokenSize = 128;
    private String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public int getTokenSize() {
        return tokenSize;
    }
    public String getCharSet(){ return charSet;}

}
