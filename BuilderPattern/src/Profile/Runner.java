package Profile;

public class Runner {
    public static void main(String[] args) {
        //by using builder method now i dont have to worry about parameters order missmatch and giving null values to opti0nal values
        UserProfile sagar=new UserProfile.Builder("Sagar",23).gender(UserProfile.Gender.M).married(false).build();
        sagar.display();

        UserProfile unknown=new UserProfile.Builder("Unknown",23).build();
        unknown.display();



    }
}
