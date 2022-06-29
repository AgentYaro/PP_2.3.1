package web.model;

public class User {
    private Long id;

    private String name;

    private String surname;

    private String patronymic;

    public User() {
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.patronymic = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return patronymic;
    }

    public void setEmail(String email) {
        this.patronymic = email;
    }

    @Override
    public String toString() {
        return "User " + "with id = " + id + " called " + name + " " + surname + " " + patronymic;
    }
}

