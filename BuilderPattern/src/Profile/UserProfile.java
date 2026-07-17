package Profile;

import java.time.LocalDate;

public class UserProfile {

    public static class Builder{
        private String name;
        private LocalDate dob;
        private int age;
        private boolean married;
        private Gender gender;

        //mandatory fields are initialised in constructor
       public Builder(String name ,int age){
           this.name = name;
           this.age = age;
           //can also set default values if needed

           this.married = false;


       }
       //optional fields have their own individual setter method to chain during creation as per need

        public Builder dob(LocalDate dob){
            this.dob = dob;
            return this;
        }

        public Builder married(boolean married){
            this.married = married;
            return this;
        }

        public Builder gender(Gender gender){
            this.gender = gender;
            return this;
        }
        //build method to create the final object with values in builder
        public UserProfile build(){
            return new UserProfile(this);
        }



    }

    public static enum Gender{
        M,F
    }

    private String name;
    private LocalDate dob;
    private int age;
    private boolean married;
    private Gender gender;

    //immutable UserProfile uses builder object to set its values
    private UserProfile(Builder builder) {
        this.name = builder.name;
        this.dob = builder.dob;
        this.age = builder.age;
        this.married = builder.married;
        this.gender = builder.gender;
    }

    public void display(){
        System.out.println("Name : "+name);
        System.out.println("Date of Birth : "+dob);
        System.out.println("Age : "+age);
        System.out.println("Married : "+married);
        System.out.println("Gender : "+gender);
    }
}
