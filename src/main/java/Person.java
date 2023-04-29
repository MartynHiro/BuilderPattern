public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String city;

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public PersonBuilder newChildBuilder() { //метод создания ребенка
        PersonBuilder child = new PersonBuilder();

        return child
                .setSurname(this.surname); //передаем ребенку фамилию родителя
    }

    public boolean hasAddress() {
        return !this.city.equals("город неизвестен");
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }


    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            System.out.println("Мы не знаем сколько человеку лет");
        }
    }

    public boolean hasAge() {
        return age >= 0 && age <= 120;
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        String ageForString;

        if (hasAge()) {
            ageForString = String.valueOf(age);
        } else {
            ageForString = "возраст неизвестен";
        }

        return "name = " + name + '\n' +
                "surname = " + surname + '\n' +
                "age = " + ageForString + '\n' +
                "city = " + city + '\n' +
                "} \n";
    }

}
