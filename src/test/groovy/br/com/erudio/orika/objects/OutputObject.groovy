package br.com.erudio.orika.objects;

class OutputObject implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    Integer age;
    
    OutputAddress address;

	public OutputAddress getAddress() {
		return address;
	}

	public void setAddress(OutputAddress address) {
		this.address = address;
	}
}