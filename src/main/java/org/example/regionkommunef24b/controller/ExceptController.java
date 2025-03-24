package org.example.regionkommunef24b.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


@RestController
@RequestMapping("/exp")
public class ExceptController {

    @GetMapping("/")
    public String hello() {
        return "hej";
    }

    @GetMapping("/file/{filename}")
    public String file(@PathVariable String filename) {
        String fileContent = "";
        try {
            FileInputStream fs = new FileInputStream("c:/AFILE/" + filename);
            try {
                byte[] b = fs.readAllBytes();
                fileContent = new String(b);
            } catch (IOException io) {
                fileContent = io.getMessage();
            } finally {
                try {
                    fs.close();
                } catch (IOException io) {
                    fileContent = "kunne ikke lukke filen";
                }
            }
        } catch (FileNotFoundException e) {
            fileContent = e.getMessage();
        }
        return fileContent;
    }

    @GetMapping("divx/{divnum1}/{divnum2}")
    public int getdivnumx(@PathVariable int divnum1, @PathVariable int divnum2) {
        int i1 = divnum1 / divnum2;
        return i1;
    }

    @GetMapping("div/{divnum1}/{divnum2}")
    public Integer getdivnum(@PathVariable Integer divnum1, @PathVariable Integer divnum2) {
        Integer i1 = divnum1 / divnum2;
        return i1;
    }


    @GetMapping("/loopi/{loopnum}")
    public int getLoopnum(@PathVariable int loopnum) {
        int x = 0;
        for (int i = 0; i < loopnum; i++) {
            x++;
        }
        return x;
    }

    @GetMapping("/loop/{loopnum}")
    public String getloop(@PathVariable String loopnum) {
        int x = Integer.parseInt(loopnum);
        return "" + x;
    }



}
