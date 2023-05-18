import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

public class TestToken implements Token {
    private String _text;
    private int tcod;

    public TestToken(String text, int tcod) {
        this._text = text;
        this.tcod = tcod;
    }

    @Override
    public String getText() {
        return _text;
    }

    @Override
    public int getType() {
        return tcod;
    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getCharPositionInLine() {
        return 0;
    }

    @Override
    public int getChannel() {
        return 0;
    }

    @Override
    public int getTokenIndex() {
        return 0;
    }

    @Override
    public int getStartIndex() {
        return 0;
    }

    @Override
    public int getStopIndex() {
        return 0;
    }

    @Override
    public TokenSource getTokenSource() {
        return null;
    }

    @Override
    public CharStream getInputStream() {
        return null;
    }
}
