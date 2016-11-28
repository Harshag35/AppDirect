package org.myvmapp.exception;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@XmlRootElement
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "VirtualMachine Not Found")
public class VirtualMachineNotFoundException extends RuntimeException {

	public VirtualMachineNotFoundException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
