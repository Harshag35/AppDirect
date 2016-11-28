package org.myvmapp;

import java.util.List;

import org.myvmapp.vm.VirtualMachine;

public interface VMService {
	/*
	 * Get a Virtual Machine by given Id.
	 */
	VirtualMachine getVirtualMachineById(String Id);

	/*
	 * List all the Virtual Machine available in inventory
	 */
	List<VirtualMachine> getVirtualMachines();

	/*
	 * Create a new Virtual Machine in inventory with a unique id.
	 */
	String createVirtualMachine(VirtualMachine vm);

	/*
	 * Delete a Virtual Machine from inventory by given ID.
	 */
	void deleteVirtualMachine(String id);

	/*
	 * Reconfigures a Virtual Machine by given VM. Id can not be changed.
	 */

	void reconfigVirtualMachine(String id, VirtualMachine vm);

	/*
	 * Initialize dummy VMs in inventory.
	 */
	void init();

}
