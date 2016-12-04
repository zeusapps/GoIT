package com.example.eugen.task004;

/**
 * Created by Eugen on 29.11.2016.
 */

public class User {
    private String _name;
    private String _gender;
    private Integer _age;
    private String _city;

    public User(String name, String gender, Integer age, String city){
        _name = name;
        _gender = gender;
        _age = age;
        _city = city;
    }

    public String getName() {
        return _name;
    }

    public String getGender() {
        return _gender;
    }

    public Integer getAge() {
        return _age;
    }

    public String getCity() {
        return _city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (_name != null ? !_name.equals(user._name) : user._name != null) return false;
        if (_gender != null ? !_gender.equals(user._gender) : user._gender != null) return false;
        if (_age != null ? !_age.equals(user._age) : user._age != null) return false;
        return _city != null ? _city.equals(user._city) : user._city == null;

    }

    @Override
    public int hashCode() {
        int result = _name != null ? _name.hashCode() : 0;
        result = 31 * result + (_gender != null ? _gender.hashCode() : 0);
        result = 31 * result + (_age != null ? _age.hashCode() : 0);
        result = 31 * result + (_city != null ? _city.hashCode() : 0);
        return result;
    }
}
