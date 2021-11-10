package clickup.ui.utils;

public class GetUrl {

    public static String getIdTeam(String url) {
        System.out.println(url);
        String[] diveList = url.split("/");
        System.out.println(diveList);
        System.out.println(diveList[3]);
        return diveList[3];
    }
}
