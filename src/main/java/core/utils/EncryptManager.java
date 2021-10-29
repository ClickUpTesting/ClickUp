/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package core.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

public final class EncryptManager {

    private EncryptManager() {
    }

    private static final int ENCODING_BYTES = 16;
    private static final int ITERATION_COUNT = 65123;
    private static final int KEY_LENGTH = 256;
    private static final byte[] BYTES = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final String PADDING = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final String CRYPTO_SPECIFICATION = "AES";

    /**
     * Encrypts a text with the given key.
     *
     * @param inputText represents the text to encrypt
     * @param key       represents the SecretKey to encrypt with
     * @throws NoSuchAlgorithmException           when algorithm is not found
     * @throws NoSuchPaddingException             when padding match is not found
     * @throws BadPaddingException                when the padding is not valid
     * @throws IllegalBlockSizeException          when the block size is not valid
     * @throws InvalidAlgorithmParameterException when there is no match for the algorithm
     * @throws InvalidKeyException                when the key is invalid
     * @return encrypted string
     * @author Jorge Caceres
     */
    private static String encrypt(final String inputText, final String key) throws InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException,
            NoSuchAlgorithmException {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, CRYPTO_SPECIFICATION);
        IvParameterSpec ivspec = new IvParameterSpec(BYTES);
        Cipher cipher = Cipher.getInstance(PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(inputText.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Decrypts a text with the retrieved key.
     *
     * @param inputText is the text to decrypt
     * @return decrypted string
     * @author Jorge Caceres
     */
    public static String decryptText(final String inputText) {
        String key = System.getenv("CLICK_UP_KEY");
        return decrypt(inputText, key);
    }

    /**
     * Decrypts a text with the provided key.
     *
     * @param inputText is the text to decrypt
     * @param key to decrypt the string
     * @throws NoSuchAlgorithmException           when algorithm is not found
     * @throws NoSuchPaddingException             when padding match is not found
     * @throws BadPaddingException                when the padding is not valid
     * @throws IllegalBlockSizeException          when the block size is not valid
     * @throws InvalidAlgorithmParameterException when there is no match for the algorithm
     * @throws InvalidKeyException                when the key is invalid
     * @return decrypted string
     * @author Jorge Caceres
     */

    private static String decrypt(final String inputText, final String key) {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, CRYPTO_SPECIFICATION);
            IvParameterSpec ivspec = new IvParameterSpec(BYTES);
            Cipher cipher = Cipher.getInstance(PADDING);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(inputText)));
        } catch (Exception e) {
            throw new InvalidParameterException("Can't decrypt, invalid key or text");
        }
    }

    /**
     * Converts the provided String key to SecretKey with the predefined salt, iterationCount and keyLength values.
     *
     * @throws NoSuchAlgorithmException when algorithm is not found
     * @throws InvalidKeySpecException  when the key is invalid
     * @return generate key
     * @author Jorge Caceres
     */
    private static String generateKey()
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        KeySpec spec = new PBEKeySpec(generatePassword().toCharArray(), BYTES, ITERATION_COUNT, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec key = new SecretKeySpec(tmp.getEncoded(), CRYPTO_SPECIFICATION);
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        return encodedKey;
    }

    /**
     * Generates a password for the PBE key specification.
     *
     * @return a String representing the password
     * @author Jorge Caceres
     */
    private static String generatePassword() {
        Random random = new SecureRandom();
        byte[] salt = new byte[ENCODING_BYTES];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
