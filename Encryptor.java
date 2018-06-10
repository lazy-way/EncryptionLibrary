import java.io.*;
import java.util.Random;

public class Encryptor {
    String normalText;
    String encryptedText;
    int encryptionID;

    private void generateEncyptionID() throws IOException {
        Random rand = new Random();
        this.encryptionID = rand.nextInt(2);
        new File("C:/Encryptor").mkdir();
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Encryptor/encryptionID.txt"));
        writer.write(Integer.toString(encryptionID));
        writer.close();
    }

    public String Encrypt(String text) throws IOException {
        int id = 0;
        normalText = text;
        BufferedReader reader;
        if (new File("C:/Encryptor/encryptionID.txt").exists()) {
            reader = new BufferedReader(new FileReader("C:/Encryptor/encryptionID.txt"));
            id = Integer.parseInt(reader.readLine());
            reader.close();
        }

        if (!new File("C:/Encryptor").exists()) {
            generateEncyptionID();
            Encrypt(text);
        } else {
            //code that will encrypt the text based on encryptionID
            if (id == 0) {
                encryptedText = convertText0(normalText);
            } else if (id == 1) {
                encryptedText = convertText1(normalText);
            }
        }
        return encryptedText;
    }

    public String Decrypt(String text) throws IOException {
        encryptedText = text;
        int id = 0;
        BufferedReader reader;
        if (new File("C:/Encryptor/encryptionID.txt").exists()) {
            reader = new BufferedReader(new FileReader("C:/Encryptor/encryptionID.txt"));
            id = Integer.parseInt(reader.readLine());
            reader.close();
        }

        if (!new File("C:/Encryptor").exists()) {
            String temp = "FirstDecryptorRunException: Decrypting tool runs before setting any encrypting id. Try running " +
                    "Encrypt method before decrypting any text.";
            return temp;
        } else {
            if (id == 0) {
                normalText = decryptText0(encryptedText);
            } else if (id == 1) {
                normalText = decryptText1(encryptedText);
            }
        }

        return normalText;
    }

    //Encrypting methods here...
    private String convertText0(String text) {
        StringBuilder sb = new StringBuilder();
        encryptedText = null;
        int i = 0;

        for (i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'a':
                    sb.append("^");
                    break;
                case 'b':
                    sb.append("$");
                    break;
                case 'c':
                    sb.append("&");
                    break;
                case 'd':
                    sb.append("#");
                    break;
                case 'e':
                    sb.append("*");
                    break;
                case 'f':
                    sb.append("@");
                    break;
                case 'g':
                    sb.append("(");
                    break;
                case 'h':
                    sb.append("!");
                    break;
                case 'i':
                    sb.append(")");
                    break;
                case 'j':
                    sb.append("~");
                    break;
                case 'k':
                    sb.append("_");
                    break;
                case 'l':
                    sb.append("`");
                    break;
                case 'm':
                    sb.append("+");
                    break;
                case 'n':
                    sb.append("1");
                    break;
                case 'o':
                    sb.append("}");
                    break;
                case 'p':
                    sb.append("2");
                    break;
                case 'q':
                    sb.append("-");
                    break;
                case 'r':
                    sb.append("3");
                    break;
                case 's':
                    sb.append("0");
                    break;
                case 't':
                    sb.append("4");
                    break;
                case 'u':
                    sb.append("9");
                    break;
                case 'v':
                    sb.append("5");
                    break;
                case 'w':
                    sb.append("8");
                    break;
                case 'x':
                    sb.append("6");
                    break;
                case 'y':
                    sb.append("7");
                    break;
                case 'z':
                    sb.append("|");
                    break;
                //Capital Letters Here...
                case 'A':
                    sb.append("{");
                    break;
                case 'B':
                    sb.append("[");
                    break;
                case 'C':
                    sb.append(":");
                    break;
                case 'D':
                    sb.append(";");
                    break;
                case 'E':
                    sb.append("<");
                    break;
                case 'F':
                    sb.append(",");
                    break;
                case 'G':
                    sb.append(".");
                    break;
                case 'H':
                    sb.append(">");
                    break;
                case 'I':
                    sb.append("/");
                    break;
                case 'J':
                    sb.append("?");
                    break;
                case 'K':
                    sb.append("=_");
                    break;
                case 'L':
                    sb.append("]");
                    break;
                case 'M':
                    sb.append("=+");
                    break;
                case 'N':
                    sb.append("=1");
                    break;
                case 'O':
                    sb.append("=}");
                    break;
                case 'P':
                    sb.append("=2");
                    break;
                case 'Q':
                    sb.append("=-");
                    break;
                case 'R':
                    sb.append("=3");
                    break;
                case 'S':
                    sb.append("=0");
                    break;
                case 'T':
                    sb.append("=4");
                    break;
                case 'U':
                    sb.append("=9");
                    break;
                case 'V':
                    sb.append("=5");
                    break;
                case 'W':
                    sb.append("=8");
                    break;
                case 'X':
                    sb.append("=6");
                    break;
                case 'Y':
                    sb.append("=7");
                    break;
                case 'Z':
                    sb.append("=|");
                    break;
                //Numbers here...
                case '1':
                    sb.append("y");
                    break;
                case '2':
                    sb.append("e");
                    break;
                case '3':
                    sb.append("t");
                    break;
                case '4':
                    sb.append("i");
                    break;
                case '5':
                    sb.append("u");
                    break;
                case '6':
                    sb.append("r");
                    break;
                case '7':
                    sb.append("q");
                    break;
                case '8':
                    sb.append("o");
                    break;
                case '9':
                    sb.append("w");
                    break;
                case '0':
                    sb.append("p");
                    break;
                //Special Characters Here...
                case ' ':
                    sb.append("==");
                    break;
                default:
                    sb.append(text.charAt(i));
                    break;
            }
        }

        encryptedText = sb.toString();
        return encryptedText;
    }

    private String convertText1(String text) {
        encryptedText = null;
        int i = 0;
        StringBuilder sb = new StringBuilder();

        for (i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'a':
                    sb.append(",");
                    break;
                case 'b':
                    sb.append(".");
                    break;
                case 'c':
                    sb.append("/");
                    break;
                case 'd':
                    sb.append("<");
                    break;
                case 'e':
                    sb.append(">");
                    break;
                case 'f':
                    sb.append("?");
                    break;
                case 'g':
                    sb.append(";");
                    break;
                case 'h':
                    sb.append(":");
                    break;
                case 'i':
                    sb.append("{");
                    break;
                case 'j':
                    sb.append("[");
                    break;
                case 'k':
                    sb.append("}");
                    break;
                case 'l':
                    sb.append("]");
                    break;
                case 'm':
                    sb.append("@");
                    break;
                case 'n':
                    sb.append("*");
                    break;
                case 'o':
                    sb.append("$");
                    break;
                case 'p':
                    sb.append("#");
                    break;
                case 'q':
                    sb.append("&");
                    break;
                case 'r':
                    sb.append("^");
                    break;
                case 's':
                    sb.append("%");
                    break;
                case 't':
                    sb.append("4");
                    break;
                case 'u':
                    sb.append(")");
                    break;
                case 'v':
                    sb.append("(");
                    break;
                case 'w':
                    sb.append("~");
                    break;
                case 'x':
                    sb.append("`");
                    break;
                case 'y':
                    sb.append("!");
                    break;
                case 'z':
                    sb.append("|");
                    break;
                //Capital Letters Here...
                case 'A':
                    sb.append("5");
                    break;
                case 'B':
                    sb.append("1");
                    break;
                case 'C':
                    sb.append("0");
                    break;
                case 'D':
                    sb.append("2");
                    break;
                case 'E':
                    sb.append("9");
                    break;
                case 'F':
                    sb.append("3");
                    break;
                case 'G':
                    sb.append("8");
                    break;
                case 'H':
                    sb.append("=:");
                    break;
                case 'I':
                    sb.append("7");
                    break;
                case 'J':
                    sb.append("6");
                    break;
                case 'K':
                    sb.append("=}");
                    break;
                case 'L':
                    sb.append("=]");
                    break;
                case 'M':
                    sb.append("=@");
                    break;
                case 'N':
                    sb.append("=*");
                    break;
                case 'O':
                    sb.append("=$");
                    break;
                case 'P':
                    sb.append("=#");
                    break;
                case 'Q':
                    sb.append("=&");
                    break;
                case 'R':
                    sb.append("=^");
                    break;
                case 'S':
                    sb.append("=%");
                    break;
                case 'T':
                    sb.append("=4");
                    break;
                case 'U':
                    sb.append("=)");
                    break;
                case 'V':
                    sb.append("=(");
                    break;
                case 'W':
                    sb.append("=~");
                    break;
                case 'X':
                    sb.append("=`");
                    break;
                case 'Y':
                    sb.append("=!");
                    break;
                case 'Z':
                    sb.append("=|");
                    break;
                //Numbers here...
                case '1':
                    sb.append("a");
                    break;
                case '2':
                    sb.append("l");
                    break;
                case '3':
                    sb.append("t");
                    break;
                case '4':
                    sb.append("b");
                    break;
                case '5':
                    sb.append("e");
                    break;
                case '6':
                    sb.append("i");
                    break;
                case '7':
                    sb.append("c");
                    break;
                case '8':
                    sb.append("k");
                    break;
                case '9':
                    sb.append("q");
                    break;
                case '0':
                    sb.append("s");
                    break;
                //Special Characters Here...
                case ' ':
                    sb.append("==");
                    break;
                default:
                    sb.append(text.charAt(i));
                    break;
            }
        }
        encryptedText = sb.toString();
        return encryptedText;
    }

    //Decrypting methods here...
    private String decryptText0(String text) {
        normalText = null;
        StringBuilder sb = new StringBuilder();
        int i = 0;

        for (i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '^':
                    sb.append("a");
                    break;
                case '$':
                    sb.append("b");
                    break;
                case '&':
                    sb.append("c");
                    break;
                case '#':
                    sb.append("d");
                    break;
                case '*':
                    sb.append("e");
                    break;
                case '@':
                    sb.append("f");
                    break;
                case '(':
                    sb.append("g");
                    break;
                case '!':
                    sb.append("h");
                    break;
                case ')':
                    sb.append("i");
                    break;
                case '~':
                    sb.append("j");
                    break;
                case '_':
                    sb.append("k");
                    break;
                case '`':
                    sb.append("l");
                    break;
                case '+':
                    sb.append("m");
                    break;
                case '1':
                    sb.append("n");
                    break;
                case '}':
                    sb.append("o");
                    break;
                case '2':
                    sb.append("p");
                    break;
                case '-':
                    sb.append("q");
                    break;
                case '3':
                    sb.append("r");
                    break;
                case '0':
                    sb.append("s");
                    break;
                case '4':
                    sb.append("t");
                    break;
                case '9':
                    sb.append("u");
                    break;
                case '5':
                    sb.append("v");
                    break;
                case '8':
                    sb.append("w");
                    break;
                case '6':
                    sb.append("x");
                    break;
                case '7':
                    sb.append("y");
                    break;
                case '|':
                    sb.append("z");
                    break;
                //Capital Letters Here...
                case '{':
                    sb.append("A");
                    break;
                case '[':
                    sb.append("B");
                    break;
                case ':':
                    sb.append("C");
                    break;
                case ';':
                    sb.append("D");
                    break;
                case '<':
                    sb.append("E");
                    break;
                case ',':
                    sb.append("F");
                    break;
                case '.':
                    sb.append("G");
                    break;
                case '>':
                    sb.append("H");
                    break;
                case '/':
                    sb.append("I");
                    break;
                case '?':
                    sb.append("J");
                    break;
                case '=':
                    if (text.charAt(i + 1) == '_') {
                        sb.append("K");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '+') {
                        sb.append("M");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '1') {
                        sb.append("N");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '}') {
                        sb.append("O");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '2') {
                        sb.append("P");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '-') {
                        sb.append("Q");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '3') {
                        sb.append("R");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '0') {
                        sb.append("S");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '4') {
                        sb.append("T");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '9') {
                        sb.append("U");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '5') {
                        sb.append("V");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '8') {
                        sb.append("W");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '6') {
                        sb.append("X");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '7') {
                        sb.append("Y");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '|') {
                        sb.append("Z");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '=') {
                        sb.append(" ");
                        i = i + 1;
                    }
                    break;
                case ']':
                    sb.append("L");
                    break;
                //Numbers here...
                case 'y':
                    sb.append("1");
                    break;
                case 'e':
                    sb.append("2");
                    break;
                case 't':
                    sb.append("3");
                    break;
                case 'i':
                    sb.append("4");
                    break;
                case 'u':
                    sb.append("5");
                    break;
                case 'r':
                    sb.append("6");
                    break;
                case 'q':
                    sb.append("7");
                    break;
                case 'o':
                    sb.append("8");
                    break;
                case 'w':
                    sb.append("9");
                    break;
                case 'p':
                    sb.append("0");
                    break;
                default:
                    sb.append(text.charAt(i));
            }
        }
        normalText = sb.toString();
        return normalText;
    }

    private String decryptText1(String text) {
        StringBuilder sb = new StringBuilder();
        normalText = null;
        int i = 0;

        for (i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case ',':
                    sb.append("a");
                    break;
                case '.':
                    sb.append("b");
                    break;
                case '/':
                    sb.append("c");
                    break;
                case '<':
                    sb.append("d");
                    break;
                case '>':
                    sb.append("e");
                    break;
                case '?':
                    sb.append("f");
                    break;
                case ';':
                    sb.append("g");
                    break;
                case ':':
                    sb.append("h");
                    break;
                case '{':
                    sb.append("i");
                    break;
                case '[':
                    sb.append("j");
                    break;
                case '}':
                    sb.append("k");
                    break;
                case ']':
                    sb.append("l");
                    break;
                case '@':
                    sb.append("m");
                    break;
                case '*':
                    sb.append("n");
                    break;
                case '$':
                    sb.append("o");
                    break;
                case '#':
                    sb.append("p");
                    break;
                case '&':
                    sb.append("q");
                    break;
                case '^':
                    sb.append("r");
                    break;
                case '%':
                    sb.append("s");
                    break;
                case '4':
                    sb.append("t");
                    break;
                case ')':
                    sb.append("u");
                    break;
                case '(':
                    sb.append("v");
                    break;
                case '~':
                    sb.append("w");
                    break;
                case '`':
                    sb.append("x");
                    break;
                case '!':
                    sb.append("y");
                    break;
                case '|':
                    sb.append("z");
                    break;
                //Capital Letters Here...
                case '5':
                    sb.append("A");
                    break;
                case '1':
                    sb.append("B");
                    break;
                case '0':
                    sb.append("C");
                    break;
                case '2':
                    sb.append("D");
                    break;
                case '9':
                    sb.append("E");
                    break;
                case '3':
                    sb.append("F");
                    break;
                case '8':
                    sb.append("G");
                    break;
                case 'H':
                    sb.append("=:");
                    break;
                case '7':
                    sb.append("I");
                    break;
                case '=':
                    if (text.charAt(i + 1) == ':') {
                        sb.append("H");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '}') {
                        sb.append("K");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == ']') {
                        sb.append("L");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '@') {
                        sb.append("M");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '*') {
                        sb.append("N");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '$') {
                        sb.append("O");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '#') {
                        sb.append("P");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '&') {
                        sb.append("Q");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '^') {
                        sb.append("R");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '%') {
                        sb.append("S");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '4') {
                        sb.append("T");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == ')') {
                        sb.append("U");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '(') {
                        sb.append("V");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '~') {
                        sb.append("W");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '`') {
                        sb.append("X");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '!') {
                        sb.append("Y");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '|') {
                        sb.append("Z");
                        i = i + 1;
                    } else if (text.charAt(i + 1) == '=') {
                        sb.append(" ");
                        i = i + 1;
                    }
                case '6':
                    sb.append("J");
                    break;
                //Numbers here...
                case 'a':
                    sb.append("1");
                    break;
                case 'l':
                    sb.append("2");
                    break;
                case 't':
                    sb.append("3");
                    break;
                case 'b':
                    sb.append("4");
                    break;
                case 'e':
                    sb.append("5");
                    break;
                case 'i':
                    sb.append("6");
                    break;
                case 'c':
                    sb.append("7");
                    break;
                case 'k':
                    sb.append("8");
                    break;
                case 'q':
                    sb.append("9");
                    break;
                case 's':
                    sb.append("0");
                    break;
                //Special Characters Here...
                default:
                    sb.append(text.charAt(i));
                    break;
            }
        }
        normalText = sb.toString();
        return normalText;
    }
}
