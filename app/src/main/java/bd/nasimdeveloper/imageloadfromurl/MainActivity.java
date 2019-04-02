package bd.nasimdeveloper.imageloadfromurl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    String wallpaper = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.pinimg.com%2Foriginals%2F2d%2Fec%2Fba%2F2decbaca70fe3f95724d3d73f6f9a72b.jpg&imgrefurl=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F814166438857107292%2F&docid=VG5PvNQ1ci68yM&tbnid=k1qVxc0UHu3UZM%3A&vet=10ahUKEwiStNPbtrDhAhUBuI8KHQDDDywQMwhqKAQwBA..i&w=1920&h=1080&bih=635&biw=1366&q=wallpaper%20for%20windows%2010&ved=0ahUKEwiStNPbtrDhAhUBuI8KHQDDDywQMwhqKAQwBA&iact=mrc&uact=8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);

        try {
            URL url = new URL(wallpaper);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bitmap);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
