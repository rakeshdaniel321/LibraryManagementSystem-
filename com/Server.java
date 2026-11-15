import controllers.BookController;
public class Server {
    public static void main(String[] args) {
        System.out.println("Server Start");
        BookController.start();
    }
}