package com.cliffconsulting.travel.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-15T21:16:59.955Z")

public class NotFoundException extends ApiException {

	private static final long serialVersionUID = 5982310011166325930L;

    
	public NotFoundException (int code, String msg) {
        super(404, msg);
    }
}
