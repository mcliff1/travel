package com.cliffconsulting.travel.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-15T21:16:59.955Z")

public class ApiException extends Exception{
	private static final long serialVersionUID = 616908699305620802L;
	private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
    
    public int getCode() {
    	return code;
    }
}
