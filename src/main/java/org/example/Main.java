package org.example;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import javax.crypto.Cipher;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class Main {
    public static void main(String[] args) {

        System.out.println(("Hello and welcome!"));

        for (int i = 1; i <= 10; i++) {
            System.out.println("i = " + i);
        }
        for (int j = 15; j > 5; j--) {
            System.out.println("j = " + j);
        }
        Security.setProperty("crypto.policy", "unlimited");
        int maxKeySize;
        try {
            maxKeySize = Cipher.getMaxAllowedKeyLength("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        //getMaxAllowedKeyLength("AES");
        System.out.println("Max Key Size for AES : " + maxKeySize);
        Provider _ = Security.getProvider("BC");
        Security.addProvider(new BouncyCastleProvider());
        try {
            CertificateFactory _ = CertificateFactory
                    .getInstance("X.509", "BC");
        } catch (CertificateException | NoSuchProviderException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(("Finally OK!"));
        }
        System.out.println(("Bye!"));
    }
}
