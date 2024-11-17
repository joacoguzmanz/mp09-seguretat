package seguretat.model.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5SecurityService {
    public String encripta(String valorOriginal) {
        String resultado = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(valorOriginal.getBytes());
            byte[] digestBytes = md.digest();

            resultado = Base64.getEncoder().encodeToString(digestBytes);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
}
