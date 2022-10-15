package in.reqres;

public class TestData {
    private String baseUri,
            email,
            password,
            name,
            job;


    public TestData setEmail(String email) {
        this.email = email;
        return this;
    }

    public TestData setPassword(String password) {
        this.password = password;
        return this;
    }

    public TestData setName(String name) {
        this.name = name;
        return this;
    }

    public TestData setJob(String job) {
        this.job = job;
        return this;
    }

}
