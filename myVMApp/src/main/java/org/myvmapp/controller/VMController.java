package org.myvmapp.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myvmapp.VMService;
import org.myvmapp.vm.VirtualMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class VMController {

	@Autowired
	private VMService vmService;

	@GetMapping("/")
	public String welcome() {// Status page, non-rest
		return "Welcome! VM Inventory Service is running!!.";
	}

	@GetMapping(value = "/status", produces = "application/json")
	public ResponseEntity<Object> status() {// Status
		Map<String, String> map = new HashMap<>();
		map.put("status", "RUNNING");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	@GetMapping("/init")
	public void init() {// Status
		vmService.init();

	}

	@GetMapping(value = "/virtualmachines", produces = "application/json")
	public List<VirtualMachine> getVirtualMachines() {
		return vmService.getVirtualMachines();
	}

	@GetMapping(value = "/virtualmachines/{id}", produces = "application/json")
	public ResponseEntity<VirtualMachine> getVirtualMachine(@PathVariable String id) {

		VirtualMachine vm = vmService.getVirtualMachineById(id);

		return new ResponseEntity<VirtualMachine>(vm, HttpStatus.OK);
	}

	@PostMapping(value = "/virtualmachines", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createVirtualMachine(@RequestBody VirtualMachine vm) {
		String id = vmService.createVirtualMachine(vm);
		System.out.println("VirtualMachine created with id: " + id);
		final URI location = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/virtualmachines/{id}")
				.build().expand(id).toUri();

		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		return new ResponseEntity<>(headers, HttpStatus.CREATED);

	}

	@DeleteMapping(value = "/virtualmachines/{id}", produces = "application/json")
	public void deleteVirtualMachine(@PathVariable String id) {
		vmService.deleteVirtualMachine(id);
	}

	@PutMapping(value = "/virtualmachines/{id}", consumes = "application/json", produces = "application/json")
	void reconfigVirtualMachine(@PathVariable String id, @RequestBody VirtualMachine vm) {
		vmService.reconfigVirtualMachine(id, vm);
	}
}
