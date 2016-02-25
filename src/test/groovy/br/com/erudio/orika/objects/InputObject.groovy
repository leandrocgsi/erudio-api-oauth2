package br.com.erudio.orika.objects;

class InputObject implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    Integer age;
    
    InputAddress address;

	public InputAddress getAddress() {
		return address;
	}

	public void setAddress(InputAddress address) {
		this.address = address;
	}
}