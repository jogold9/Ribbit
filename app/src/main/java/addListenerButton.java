import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.joshbgold.ribbit.R;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * Created by JoshG on 8/6/2015.
 */
public class addListenerButton {

    private String text = "";
    private int ipaddresses[];
    private String iptouse;
    private int counter = 0;
    private boolean connectedtoipsuccess = false;

    public void addListenerOnButton()
    {

        btnClick = (Button) findViewById(R.id.checkipbutton);

        btnClick.setOnClickListener(new View.OnClickListener()
        {
            byte[] response = null;
            @Override
            public void onClick(View arg0)
            {

                text = (TextView) findViewById(R.id.textView2);

                Thread t = new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        for (int i = 0; i < ipaddresses.length; i++)
                               counter = i;
                        {

                            try
                            {
                                response = Get(ipaddresses[counter]);
                                if (response == null)
                                    text.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            counter++;
                                            text.setText("Connection Failed: " + ipaddresses[counter]);
                                        }
                                    });
                            }
                            catch (Exception e)
                            {
                                String err = e.toString();
                            }

                            if (response!=null)
                            {


                                try
                                {
                                    final String a = new String(response, "UTF-8");
                                    text.post(new Runnable()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            text.setText(a);
                                        }
                                    });

                                    iptouse = ipaddresses[i].substring(0, 26);
                                    connectedtoipsuccess = true;
                                    Logger.getLogger("MainActivity(inside thread)").info(a);
                                } catch (UnsupportedEncodingException e)
                                {
                                    e.printStackTrace();
                                    Logger.getLogger("MainActivity(inside thread)").info("encoding exception");
                                }

                                Logger.getLogger("MainActivity(inside thread)").info("test1");
                                break;

                            }
                            else
                            {

                            }
                        }
                        counter = 0;
                    }
                });
                t.start();
            }
        });

    }
}
