import com.eel.errors.ErrorType;
import com.eel.errors.Errors;
import org.junit.Test;

public class ErrorTests {
    private final Errors errors = new Errors();

    @Test
    public void AddsItemToErrors() {
        ErrorType type = ErrorType.TYPE_ERROR;
        String message = "ErrorMessage";

        errors.addEntry(type, message);

        assert (!errors.isEmpty());
    }
}
