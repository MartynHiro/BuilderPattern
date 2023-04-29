public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1; //на возрасте и городе значения по умолчанию на случай, если их не введут
    private String city = "город неизвестен";

    //методы для заполнения полей билдером

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
//защитились от некорректных возрастов
        if (age >= 0 && age <= 120) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Вы ввели некорректные данные");
        }
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    //метод построения объекта из инициализированных полей
    public Person build() {
//защитились от ввода недостаточного количества данных для минимального заполнения объекта
        if (name == null || surname == null) {
            throw new IllegalStateException("Вы ввели недостаточное количество данных");
        }

        return new Person(name, surname, age, city);

    }
}
