package com.att.tlv.training.java.optional;

import java.util.Optional;

public class Optionals {

    public static void main(String[] args) {
        Street street = new Street("Main", 2);
        Address address = new Address(street, 6019000, "Dallas");
        Company att = new Company(address, "at&t");

        new Optionals().printCityTheWrongWay(att);
    }
    
    public void printCityTheWrongWay(Company company) {
        // Print the company city or "UNKNOWN"

        // According to the business rules, Address is optional. We're used to say that it
        // is valid for Address to be null.
        // So this won't work:
        // String city = company.getAddress().getCity();
        
        Optional<Address> optionalAddress = company.getAddress();
        Optional<String> city = optionalAddress
                .map(Address::getCity);
        
        // This is the WRONG way to do it!
        if (city.isPresent()) {
            System.out.println(city.get());
        }
        else {
            System.out.println("UNKNOWN");
        }
    }

    public void printCity(Company company) {
        // Print the company city or "UNKNOWN"

        // According to the business rules, Address is optional. We're used to say that it
        // is valid for Address to be null.
        // So this won't work:
        // String city = company.getAddress().getCity();

        String city = company.getAddress()
                .map(Address::getCity)
                .orElse("UNKNOWN");

        System.out.println(city);
    }

    public void printStreetOrUnknown(Company company) {
        String streetName = company.getAddress()
                .flatMap(Address::getStreet)
                .map(Street::getName)
                .orElse("UNKNOWN");

        System.out.println(streetName);
    }
    
    public void printStreetOrComputeValue(Company company) {
        String streetName = company.getAddress()
                .flatMap(Address::getStreet)
                .map(Street::getName)
                .orElseGet(this::someExpensiveOrRuntimeDependentCalculation);
        
        System.out.println(streetName);
    }
    
    private String someExpensiveOrRuntimeDependentCalculation() {
        return Double.toHexString(Math.random());
    }

    public void printStreetIfPresent(Company company) {
        company.getAddress()
                .flatMap(Address::getStreet)
                .map(Street::getName)
                .ifPresent(System.out::println);
    }

    public void printStreetOrThrow(Company company) {
        String streetName = company.getAddress()
                .flatMap(Address::getStreet)
                .map(Street::getName)
                .orElseThrow(IllegalArgumentException::new);
        
        System.out.println(streetName);
    }
    
    public void printStreetIfNotEmptyOrThrow(Company company) {
        String streetName = company.getAddress()
                .flatMap(Address::getStreet)
                .map(Street::getName)
                .filter(name -> !name.isEmpty())
                .orElseThrow(IllegalArgumentException::new);

        System.out.println(streetName);
    }
    
    private static class Company {

        private final Address address;
        private final String name;

        public Company(Address address, String name) {
            this.address = address;
            this.name = name;
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }

        public String getName() {
            return name;
        }
    }

    private static class Address {

        private final Street street;
        private final int postalCode;
        private final String city;

        public Address(Street street, int postalCode, String city) {
            this.street = street;
            this.postalCode = postalCode;
            this.city = city;
        }

        public Optional<Street> getStreet() {
            return Optional.ofNullable(street);
        }

        public int getPostalCode() {
            return postalCode;
        }

        public String getCity() {
            return city;
        }
    }

    private static class Street {

        private final String name;
        private final int number;

        public Street(String name, int number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }
    }
}
