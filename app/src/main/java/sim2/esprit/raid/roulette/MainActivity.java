package sim2.esprit.raid.roulette;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PowerManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import sim2.esprit.raid.roulette.Ressources.Classes.Game;
import sim2.esprit.raid.roulette.Ressources.Classes.Round;
import sim2.esprit.raid.roulette.Ressources.Classes.Utils;


public class MainActivity extends AppCompatActivity {

    private ImageView imageRoulette;
    private ImageView imageBall;
    int a;
    int b;
    int c;

    int winningnumber=-1 ;

    TextView  msg,mwinner;        CountDownTimer timer;

    String message = "";
    ServerSocket serverSocket;
    Spinner client ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "MyWakelockTag");
        wakeLock.acquire();
        String appVersion = "v1";
        Backendless.initApp( this, "90AAA3BC-7A12-C560-FF51-67F0FF7CDF00", "0D351D4D-340C-4495-FFC5-8D5C28B29A00", appVersion );



        Backendless.Data.mapTableToClass("Game",Game.class);
        Backendless.Data.mapTableToClass("Round",Round.class);
        imageRoulette = (ImageView) findViewById(R.id.image_roulette);
        imageBall = (ImageView) findViewById(R.id.image_ball);



        mwinner = (TextView) findViewById(R.id.winnernumber);





        Thread socketServerThread = new Thread(new SocketServerThread());
        socketServerThread.start();





    }

    public void actionRoulette(View view) {
        int corner = 360/38; // corner for point
        int randPosition = corner * new Random().nextInt(38); // random point
        int MIN = 5; // min rotation
        int MAX = 9; // max rotation
        long TIME_IN_WHEEL = 1000;  // time in one rotation
        int randRotation = MIN + new Random().nextInt(MAX-MIN); // random rotation

        int truePosition =  randRotation * 360 + randPosition;
        long totalTime = TIME_IN_WHEEL * randRotation + (TIME_IN_WHEEL/360) * randPosition;

        Log.e("ROULETTE_ACTION","randPosition : " + randPosition
                + " randRotation : " + randRotation
                + " totalTime : " + totalTime
                + " truePosition : " + truePosition);

        a=randPosition;
        /*if (randRotation >= 80 && randRotation <= 90) {
            Toast.makeText(this, "Anta fi 6",
                    Toast.LENGTH_LONG).show();
// do action
        }
        switch(randPosition) {
            case 0 :
                Toast.makeText(this, "Anta fi 0",
                        Toast.LENGTH_LONG).show();
// Statements
                break; // optional

            case 63 :
                Toast.makeText(this, "Anta fi 33",
                        Toast.LENGTH_LONG).show();// Statements
            case 108 :
                Toast.makeText(this, "Anta fi 31",
                        Toast.LENGTH_LONG).show();// Statements
            case 243 :
                Toast.makeText(this, "Anta fi 15",
                        Toast.LENGTH_LONG).show();// Statements
            case 162 :
                Toast.makeText(this, "Anta fi 10",
                        Toast.LENGTH_LONG).show();// Statements
            case 90 :
                Toast.makeText(this, "Anta fi 6",
                        Toast.LENGTH_LONG).show();// Statements
            case 288 :
                Toast.makeText(this, "Anta fi 32",
                        Toast.LENGTH_LONG).show();// Statements
            case 135 :
                Toast.makeText(this, "Anta fi 12",
                        Toast.LENGTH_LONG).show();// Statements
            case 324 :
                Toast.makeText(this, "Anta fi 30",
                        Toast.LENGTH_LONG).show();// Statements
            case 261 :
                Toast.makeText(this, "Anta fi 22",
                        Toast.LENGTH_LONG).show();// Statements
                break; // optional

            // You can have any number of case statements.
            default : // Optional
                // Statements
        }*/
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0f,(float)truePosition);
        animator.setDuration(totalTime);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                imageRoulette.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                imageRoulette.setEnabled(true);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animator.start();

    }
    public void actionBall(View view1) {
        int corner = 360/38; // corner for point
        int randPositione = corner * new Random().nextInt(38); // random point
        int MIN = 5; // min rotation
        int MAX = 9; // max rotation
        long TIME_IN_WHEEL = 1000;  // time in one rotation
        int randRotation = MIN + new Random().nextInt(MAX-MIN); // random rotation

        int truePosition =  randRotation * 360 + randPositione ;
        long totalTime = TIME_IN_WHEEL * randRotation + (TIME_IN_WHEEL/360) * randPositione;

        Log.e("ROULETTE_ACTION","randPosition : " + randPositione
                + " randRotation : " + randRotation
                + " totalTime : " + totalTime
                + " truePosition : " + truePosition);

        b=randPositione;



        ObjectAnimator animator = ObjectAnimator.ofFloat(view1,"rotation",0f,(float)truePosition);
        animator.setDuration(totalTime);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                imageBall.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                imageBall.setEnabled(true);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animator.start();




    }
    private void registerrUser(int n) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.updateUserDataInBackground(n, new GetUserCallback() {
            @Override
            public void done(int returnedUser) {
                Toast.makeText(MainActivity.this, "Done and sent"+new GettingNumber().getNumberByAngle(returnedUser),
                        Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private class SocketServerThread extends Thread {

        static final int SocketServerPORT = 8080;
        int count = 0;
        long remaining = 0;
        String winner = "" ;


        ArrayList<String> clients= new ArrayList<>();
        HashMap<String,BackendlessUser> users = new HashMap<>()
;
        @Override
        public void run() {
            Socket socket = null;
            DataInputStream dataInputStream = null;
            DataOutputStream dataOutputStream = null;

            Game  g = new Game() ;
            g.setTypeGame("roulette");

          Backendless.Persistence.save( g );

            MainActivity.this.runOnUiThread(new Runnable() {

                @Override
                public void run() {



                    timer = new CountDownTimer(30000, 1000) {
                        @Override
                        public void onTick(long l) {
                            remaining=l / 1000;
                        }



                        @Override
                        public void onFinish() {
                            remaining=-1;



                            System.gc();
                            actionBall(imageBall);
                            actionRoulette(imageRoulette);


                            c=b-a;
                            GettingNumber.add();
                                  winningnumber =  new GettingNumber().getNumberByAngle(c) ;

                            if( GettingNumber.balck.contains(new GettingNumber().getNumberByAngle(c))) {

                                winner="black";
                            }

                            else {

                                winner="red";

                            }


                            mwinner.setText(winner);


                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    timer.start();
                                    remaining=30;

                                }
                            }, 5000);



                        }
                    }.start();

                }
            });



            try {
                serverSocket = new ServerSocket(SocketServerPORT);
                MainActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                    }
                });

                while (true) {
                    socket = serverSocket.accept();
                    dataInputStream = new DataInputStream(
                            socket.getInputStream());

                    dataOutputStream = new DataOutputStream(
                            socket.getOutputStream());


                    String messageFromClient = "";

                    //If no message sent from client, this code will block the program
                    messageFromClient = dataInputStream.readUTF();
                    if (messageFromClient.equals("getresult")){

                        final DataOutputStream finalDataOutputStream = dataOutputStream;

                        final DataOutputStream finalDataOutputStream1 = dataOutputStream;
                        MainActivity.this.runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                try {
                                    finalDataOutputStream1.writeUTF(String.valueOf(remaining));
                                    Log.d("lllppp",String.valueOf(remaining));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }


                            }
                        });

                    }

                    String s1 = "";
                    try {
                      s1 =messageFromClient.substring(0,messageFromClient.lastIndexOf("x")) ;
                    }
                    catch ( StringIndexOutOfBoundsException s ) {

                    }

                     if (s1.equals("black")||s1.equals("red") ){
                        Round r = new Round();
                        String s =  messageFromClient.substring(messageFromClient.lastIndexOf("x")+1);

               Double userbet  = Double.valueOf(s);
                        r.setResultfloat(userbet);
                        r.setGame(g);
                         r.useremail = users.get(socket.getInetAddress().getHostAddress()).getEmail(); ;
                        r.setUser(users.get(socket.getInetAddress().getHostAddress()));
                        if(messageFromClient.equals(winner)){
                            dataOutputStream.writeUTF("you win");

                            r.setResult(1);


                        }


                        else {
                            dataOutputStream.writeUTF("you lose");
                            r.setResult(0);
                        }


                        Backendless.Persistence.save( r );


                    }

                    else if (messageFromClient.equals("no") ){

                        dataOutputStream.writeUTF("you havent participated in the last round");


                    }
                     else if (Utils.isNumeric(s1)){
                         int betnumber = Integer.parseInt(s1) ;

                         Round r = new Round();
                         String s =  messageFromClient.substring(messageFromClient.lastIndexOf("x")+1);

                         Double userbet  = Double.valueOf(s);
                         r.setResultfloat(userbet);
                         r.setGame(g);
                         r.useremail = users.get(socket.getInetAddress().getHostAddress()).getEmail(); ;
                         r.setUser(users.get(socket.getInetAddress().getHostAddress()));

                         if( betnumber==winningnumber) {


                             dataOutputStream.writeUTF("you win");

                             r.setResult(1);

                         }
                            else {
                             dataOutputStream.writeUTF("you lose");

                             r.setResult(0);
                         }

                         Backendless.Persistence.save( r );

                     }
                    else {
                        count++;
                         Log.v("ssssssss",messageFromClient ) ;
                        String clientadress = socket.getInetAddress().getHostAddress();

           if ( users.get(socket.getInetAddress().getHostAddress())==null) {
               BackendlessUser u;
               u = Backendless.Persistence.of(BackendlessUser.class).findById(messageFromClient);

               users.put(clientadress, u);
               message += "#" + count + " from " + socket.getInetAddress().getHostName()
                       + ":" + socket.getPort() + "\n"
                       + "Msg from client: " + messageFromClient + "\n";


               final BackendlessUser finalU = u;
               MainActivity.this.runOnUiThread(new Runnable() {

                   @Override
                   public void run() {
                       Snackbar snackbar = Snackbar
                               .make(MainActivity.this.findViewById(android.R.id.content), finalU.getProperty("name").toString() + "joined the battle", Snackbar.LENGTH_LONG);

                       snackbar.show();
//
                   }
               });

               String msgReply = "Hello from smart casino, you are  player  number #" + clients.indexOf(clientadress) + 1;
               dataOutputStream.writeUTF(msgReply);

           }
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                final String errMsg = e.toString();
                MainActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                   Log.v(errMsg,"exxxx");
                    }
                });

            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private String getIpAddress() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress.nextElement();

                    if (inetAddress.isSiteLocalAddress()) {
                        ip += "SiteLocalAddress: "
                                + inetAddress.getHostAddress() + "\n";
                    }

                }

            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ip += "Something Wrong! " + e.toString() + "\n";
        }

        return ip;
    }


    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}
