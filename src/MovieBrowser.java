import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MovieBrowser {
    static JsonArray getMoviesByGenre(int genreId) throws Exception {
        String urlString = "https://api.themoviedb.org/3/discover/movie?api_key="
                + "c968ab24f0eb8547c8a89c3acc8c7b86" + "&language=pt-BR&with_genres=" + genreId;

        URI uri = new URI(urlString);
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(conn.getInputStream());
        JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
        reader.close();

        return json.getAsJsonArray("results");
    }
}

