package com.tecacet.jtemplates;

public class RenderException extends RuntimeException {

    public RenderException(Exception e) {
        super(e);
    }

    public RenderException(String string) {
        super(string);
    }

}
