package at.cinephilia.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jens on 31.08.14.
 */
public class GetTheFuckingHash {

    public int getTheHashCode(String value_1, String value_2) {

        int result = 0;
        result = value_1.hashCode();
        result = result * 31 + (value_2.hashCode());
        return result;
    }

    public int hashCode(String participant_ID, String movie_ID, String diractor) {
        int result = participant_ID != null ? participant_ID.hashCode() : 0;
        result = 31 * result + (movie_ID != null ? movie_ID.hashCode() : 0);
        result = 31 * result + (diractor != null ? diractor.hashCode() : 0);
        return result;
    }

    public String getAMd5Hash(String value_1, String value_2) throws NoSuchAlgorithmException {
        String value_one = value_1;
        String value_two = value_2;
        String toGenerate = value_one + value_two;
        String generated;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(toGenerate.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x2, 16).substring(1));
        }
        generated = sb.toString();
        return generated;
    }

}
