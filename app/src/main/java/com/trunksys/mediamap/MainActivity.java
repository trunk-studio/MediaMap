package com.trunksys.mediamap;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class MainActivity extends Activity implements OnClickListener{

    EditText rtspUrl ;
    Button playButton ;
    VideoView videoView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rtspUrl = (EditText)this.findViewById(R.id.editText);
        videoView = (VideoView)this.findViewById(R.id.rtspVideo);
        playButton = (Button)this.findViewById(R.id.playButton);
        playButton.setOnClickListener(this);

        rtspUrl.setText("http://www.ebookfrenzy.com/android_book/movie.mp4");

        //rtsp://v6.cache1.c.youtube.com/CjYLENy73wIaLQkDsLHya4-Z9hMYDSANFEIJbXYtZ29vZ2xlSARSBXdhdGNoYKX4k4uBjbOiUQw=/0/0/0/video.3gp
        //rtsp://mpv.cdn3.bigCDN.com:554/bigCDN/definst/mp4:bigbuckbunnyiphone_400.mp4

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.playButton:
                RtspStream(rtspUrl.getEditableText().toString());
                break;
        }
    }

    private void RtspStream(String rtspUrl){
        videoView.setVideoURI(Uri.parse(rtspUrl));
        videoView.requestFocus();
        videoView.start();
    }

}