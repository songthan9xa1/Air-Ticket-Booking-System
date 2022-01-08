package Ulti;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String TEXT_PATTERN = "^[a-zA-Z]+$";
    
    public Validator() {
        
    }

    /**
     * Validate hex with regular expression
     * 
     * @param hex
     *            hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean emailValidate(final String hex) {
    	pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
    
    public boolean textValidate(final String hex) {
    	pattern = Pattern.compile(TEXT_PATTERN);
        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
    
    public boolean passwordValidate(String password) {
    	if (password.length() >= 8) return true;
    	return false;
    }
}
