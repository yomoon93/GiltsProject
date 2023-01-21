public class AlreadyExpiredGiltException extends GiltException{
    public AlreadyExpiredGiltException() {
        super("Gilt has already expired.");
    }

    public AlreadyExpiredGiltException(Gilt g) {
        super("Already expired gilt: " + g);
    }
}
