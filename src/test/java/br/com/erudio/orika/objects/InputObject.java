package br.com.erudio.orika.objects;

import java.io.Serializable;

public class InputObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    
    private InputAddress address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public InputAddress getAddress() {
        return address;
    }

    public void setAdress(InputAddress address) {
        this.address = address;
    }    
}
