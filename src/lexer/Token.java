package lexer;

import tokentypes.Tokens;

public record Token(Tokens type, String word) {
}
