package seguretat.model.service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESSecurityService {
    private final String ENCRYPT_KEY = "clave-32-chars__________________";
    private final String ENCRYPT_ALGORITHM = "AES";
    // private final String CODE = "UTF-8";

    public String encripta(String valorOriginal) {

        String result = null;

        byte[] encrypted = null;
        try {
            Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encrypted = cipher.doFinal(valorOriginal.getBytes());

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
                 | BadPaddingException e) {
            System.err.println(e.getMessage());

        }

        if (encrypted != null) {
            result = Base64.getEncoder().encodeToString(encrypted);
        }

        return result;

    }

    public String desencripta(String encrypted) {
        String result = null;
        byte[] encryptedBytes = null;

        try {
            Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);

            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, aesKey);

            encryptedBytes = Base64.getDecoder().decode(encrypted);
            result = new String(cipher.doFinal(encryptedBytes));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
                 | BadPaddingException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }
}
