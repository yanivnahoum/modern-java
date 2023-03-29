package com.att.tlv.training.java.optional;

public class BeforeOptional {
    
    public static void main(String[] args) {
        Street street = new Street("Main", 2);
        Address address = new Address(street, 6019000, "Dallas");
        Company att = new Company(address, "at&t");
        
        new BeforeOptional().printStreetWithMethodChaining(att);        
    }
    
    
    public void printStreetWithMethodChaining(Company company) {
        // Print the company street name
        
        // Simple - just use method chaining, right?
        System.out.println(company.getAddress().getStreet().getName());
        
        
        
        
        // Otherwise know as the train wreck anti-pattern....
        // No safe navigation operator as of Java 20 :-(
        // System.out.println(company?.getAddress()?.getStreet()?.getName());
    }
    
    
    public void printStreetWithNullChecks(Company company) {
        // Print the company street name or "UNKNOWN"
        
        String streetName = "UNKNOWN";
        if (company != null) {
            Address address = company.getAddress();
            if (address != null) {
                Street street = address.getStreet();
                if (street != null) {
                    streetName = street.getName();
                }
            }
        }
        
        System.out.println(streetName);
    }
    
    private static class Company {
        
        private final Address address;
        private final String name;
        
        public Company(Address address, String name) {
            this.address = address;
            this.name = name;
        }

        public Address getAddress() {
            return address;
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

        public Street getStreet() {
            return street;
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
