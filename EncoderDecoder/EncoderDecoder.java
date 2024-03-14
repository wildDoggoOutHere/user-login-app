import java.util.*;

public class EncoderDecoder {
    private static final List<Character> referenceList = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '(', ')', '*', '+', ',', '-', '.', '/');

    public String encode(String plainText) {
        Random random = new Random();
        char offset = referenceList.get(random.nextInt(referenceList.size()));
        return encode(plainText, offset);
    }

    public String encode(String plainText, char offset) {
        int shift = referenceList.indexOf(offset);
        StringBuilder encodedText = new StringBuilder();

        for (char c : plainText.toCharArray()) {
            int index = referenceList.indexOf(c);
            if (index != -1) {
                int newIndex = (index - shift + referenceList.size()) % referenceList.size();
                encodedText.append(referenceList.get(newIndex));
            } else {
                encodedText.append(c);
            }
        }

        return offset + encodedText.toString();
    }

    public String decode(String encodedText) {
        char offset = encodedText.charAt(0);
        int shift = referenceList.indexOf(offset);
        StringBuilder decodedText = new StringBuilder();

        for (int i = 1; i < encodedText.length(); i++) {
            char c = encodedText.charAt(i);
            int index = referenceList.indexOf(c);
            if (index != -1) {
                int newIndex = (index + shift) % referenceList.size();
                decodedText.append(referenceList.get(newIndex));
            } else {
                decodedText.append(c);
            }
        }

        return decodedText.toString();
    }

    public static void main(String[] args) {
        EncoderDecoder encoder_1 = new EncoderDecoder();
        String plainText = "HELLO WORLD";
        String encodedText = encoder_1.encode(plainText);
        // String encodedText = encoder_1.encode(plainText, 'B');
        System.out.println("Encoded text: " + encodedText);

        String decodedText = encoder_1.decode(encodedText);
        System.out.println("Decoded text: " + decodedText);

    }
}