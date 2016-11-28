package org.myvmapp.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.myvmapp.VMService;
import org.myvmapp.exception.VirtualMachineNotFoundException;
import org.myvmapp.vm.VMState;
import org.myvmapp.vm.VirtualMachine;
import org.springframework.stereotype.Component;

@Component
public class VMServiceImpl implements VMService {

	// Create an inventory with initial size 64.
	private Map<String, VirtualMachine> inventory = new HashMap<String, VirtualMachine>(32);

	public VMServiceImpl() {

	}

	public void init() {
		// Init for dummy VMs
		VirtualMachine vm1 = new VirtualMachine();
		vm1.setCpu(4);
		vm1.setMemory(2048);
		vm1.setName("VM-1");
		vm1.setOwner("HKG");
		vm1.setVersion("10.0");
		vm1.setStorage(20);
		vm1.setState(VMState.ON);
		createVirtualMachine(vm1);

		VirtualMachine vm2 = new VirtualMachine();
		vm2.setCpu(4);
		vm2.setMemory(2048);
		vm2.setName("VM-1");
		vm2.setOwner("HKG");
		vm2.setVersion("10.0");
		vm2.setStorage(20);
		vm2.setState(VMState.OFF);
		createVirtualMachine(vm2);
	}

	@Override
	public VirtualMachine getVirtualMachineById(String id) {
		VirtualMachine vm = inventory.get(id);
		if (vm == null)
			throw new VirtualMachineNotFoundException("Virtual Mchine Not found for id: " + id);
		return vm;

	}

	@Override
	public List<VirtualMachine> getVirtualMachines() {
		return new ArrayList<>(inventory.values());
	}

	@Override
	public String createVirtualMachine(VirtualMachine vm) {
		vm.setId(UUID.randomUUID().toString());
		inventory.put(vm.getId(), vm);
		return vm.getId();
	}

	@Override
	public void deleteVirtualMachine(String id) {
		getVirtualMachineById(id);
		inventory.remove(id);
	}

	@Override
	public void reconfigVirtualMachine(String id, VirtualMachine vm) {
		if (getVirtualMachineById(id) != null) {
			vm.setId(id);
			deleteVirtualMachine(id);
			inventory.put(vm.getId(), vm);
		}

	}
}
