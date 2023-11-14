package site.nomoreparties.stellarburgers.generation;
import org.apache.commons.lang3.RandomStringUtils;
import site.nomoreparties.stellarburgers.resources.UserCard;

public class GenerateUserData {
    private String userEmail;
    private String userPassword;
    private String userName;

    private String generateRandomString(int countOfSymbols) {
        return RandomStringUtils.randomAlphabetic(countOfSymbols);
    }

    private void generateEmailPassName(int countOfSymbols) {
        userEmail = (generateRandomString(countOfSymbols) + "@yandex.ru");
        userPassword = generateRandomString(countOfSymbols);
        userName = generateRandomString(countOfSymbols);
    }

    public UserCard generateNewUserCard(int countOfSymbols)
    {
        generateEmailPassName(countOfSymbols);
        return new UserCard(
                getUserEmail(),
                getUserPassword(),
                getUserName());
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }
}
