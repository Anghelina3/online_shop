package usersAPP;

public interface IUser {
       String getName();
       String getLogin();
       String getPassword();
       void setLogin(String login);
       void setPassword(String password);
       IBasket getBasket();
       void setBasket(IBasket basket);
}
