package at.cinephilia.data;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TheStart {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {


        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ctx.register(AppConf.class);
        //ctx.refresh();

//        GetGenres getGenres = ctx.getBean(GetGenres.class);
//        getGenres.saveGenre();


//        DataFromSpiderman fromSpiderman = new DataFromSpiderman();
//        JsonArray jsonArray = fromSpiderman.getJsonObject().getJsonArray("genres");
//
//        for (JsonObject jsonObject : jsonArray.getValuesAs(JsonObject.class)) {
//            System.out.println(jsonObject.getString("name"));
//            System.out.println(jsonObject.getString("_ID"));
//            String name = jsonObject.getString("name");
//            String _ID = jsonObject.getString("_ID");
//            Genre genre = new Genre(name, _ID);
//
//        }

        //URL url = new URL("http://localhost:8081/theaters/get");
        //InputStream inputStream = url.openStream();

        //URL participantsUrl = new URL("http://localhost:8081/common/participants");
        //InputStream inputStreamParticipants = participantsUrl.openStream();

        //String m_id = "m-rush2014";
        //System.out.println(m_id.hashCode());

        String participant_id = "d-carolreed";
        String movie_id = "m-derdrittemann1949";
        String toGenerate = participant_id + movie_id;
        String generated;

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(toGenerate.getBytes());

        byte[] bytes = md.digest();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x2, 16).substring(1));
        }

        generated = sb.toString();

        System.out.println("::");
        System.out.println(generated);
        System.out.println(md.toString());



    }

}
