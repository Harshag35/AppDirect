package org.myvmapp.vm;

public class VirtualMachine {

	// Name of the virtual machine
	private String name;

	// Unique Id of the virtual machine
	private String id;

	// Version of the virtual machine
	private String version;

	// Owner of the virtual machine.(VM is requested by)
	private String owner;

	// CPU of the virtual machine
	private Integer cpu;

	// Total Storage in GB of the virtual machine
	private Integer storage;

	// Total Memory in MB
	private Integer memory;

	// VM state (It can be ON , OFF, SUSPENDED)
	private VMState state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getCpu() {
		return cpu;
	}

	public void setCpu(Integer cpu) {
		this.cpu = cpu;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public Integer getMemory() {
		return memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	public VMState getState() {
		return state;
	}

	public void setState(VMState state) {
		this.state = state;
	}

	// @Override
	public boolean equals1(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		/*
		 * Check if obj is an instance of VirtualMachine or not
		 * "null instanceof [type]" also returns false
		 */
		if (!(obj instanceof VirtualMachine)) {
			return false;
		}
		// Type cast obj to VirtualMachine so that we can compare data members
		VirtualMachine another = (VirtualMachine) obj;
		return this.getId().equals(another.getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpu == null) ? 0 : cpu.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		VirtualMachine other = (VirtualMachine) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "VirtualMachine [name=" + name + ", id=" + id + ", version=" + version + ", owner=" + owner + ", cpu="
				+ cpu + ", storage=" + storage + ", memory=" + memory + ", state=" + state + "]";
	}

}
