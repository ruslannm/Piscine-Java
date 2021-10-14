import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MyRunnable implements Runnable {
    private int id;
    private List<String> urlList;
    private CounterUrls counterUrls;

    public MyRunnable(int id, List<String> urlList, CounterUrls counterUrls) {
        this.id = id;
        this.urlList = urlList;
        this.counterUrls = counterUrls;
    }

    public void run() {
        int i = 0;
        String fileName;
        while ((i = counterUrls.getCounter()) != 0) {
            String[] url = urlList.get(i - 1).split(" ");
            if (url.length == 1) {
                System.err.println("Error: invalid text");
                System.exit(-1);
            }
            System.out.println("Thread-" + id + " start download file number " + url[0]);
            String[] urlPath = url[1].split("/");
            if (urlPath.length == 1) {
                System.err.println("Error: invalid text");
                System.exit(-1);
            }
            fileName = urlPath[urlPath.length - 1];
            try {
                downloadUsingStream(url[1], fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-" + id + " finish download file number " + url[0]);
        }
    }

    private static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(5000);
        connection.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
        connection.addRequestProperty("User-Agent", "Mozilla");
        connection.addRequestProperty("Referer", "google.com");

        int status = connection.getResponseCode();

        boolean redirect = false;
        if (status != HttpURLConnection.HTTP_OK) {
            if (status == HttpURLConnection.HTTP_MOVED_TEMP
                    || status == HttpURLConnection.HTTP_MOVED_PERM
                    || status == HttpURLConnection.HTTP_SEE_OTHER)
                redirect = true;
        }
        if (redirect) {
            String newUrl = connection.getHeaderField("Location");
            String cookies = connection.getHeaderField("Set-Cookie");
            connection = (HttpURLConnection) new URL(newUrl).openConnection();
            connection.setRequestProperty("Cookie", cookies);
            connection.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
            connection.addRequestProperty("User-Agent", "Mozilla");
            connection.addRequestProperty("Referer", "google.com");
        }
        BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
}
