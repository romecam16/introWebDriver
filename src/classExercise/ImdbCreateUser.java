package classExercise;

public class ImdbCreateUser extends ImdbBase {

    static String user = "Pedro";
    static String password = "test1234";
    static String url = "https://www.imdb.com";
    static String browser = "chrome";



    public static void main(String args[]) {
        //arrancar el navegador
        initBrowser(url,browser);
        //crear usuario
        createUser(user, password);
        //validate user
        validateUser(user);
        //cerrar browser
        closeBrowser();


    }
}
