package com.thoughtworks.tw101;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by lduan on 9/29/16.
 */
public class InputReader {


    private BufferedReader bufferedReader;

    public InputReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String getString() {
        String result = "x";
        try{
            result = bufferedReader.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
