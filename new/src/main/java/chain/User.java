package chain;


import chain.annotate.BaseLength;
import chain.annotate.NotEmpty;
import chain.annotate.NotNull;

public class User {
    @NotEmpty
    private String name;

    @NotNull
    private Integer age;

    @BaseLength(min = 2, max = 5)
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
