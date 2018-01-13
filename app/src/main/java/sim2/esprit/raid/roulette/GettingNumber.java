package sim2.esprit.raid.roulette;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Raid on 1/20/17.
 */

public class GettingNumber{

public static   ArrayList<DesignedNumber> listaton = new ArrayList<DesignedNumber>();

    public static   ArrayList<Integer> balck = new ArrayList<Integer>(){

    };

    public static void add() {
        balck.addAll(new ArrayList<Integer>( Arrays.asList(9, 15, 24,33,36,2,8,11,17,20,26,29,35,4,10,13,22,28,31) ));
    };

public GettingNumber(){


 DesignedNumber nb = new DesignedNumber(32,72);
 listaton.add(nb);
    DesignedNumber nbg = new DesignedNumber(25,147);
    listaton.add(nbg);

    DesignedNumber nba = new DesignedNumber(15,117);
    listaton.add(nba);

    DesignedNumber nbw = new DesignedNumber(27,189);
    listaton.add(nbw);

    DesignedNumber nbe = new DesignedNumber(12,-135);
    listaton.add(nbe);

    DesignedNumber nbr = new DesignedNumber(22,99);
    listaton.add(nbr);

    DesignedNumber nbt = new DesignedNumber(29,216);
    listaton.add(nbt);

    DesignedNumber nbttt = new DesignedNumber(33,297);
    listaton.add(nbttt);


    DesignedNumber nby = new DesignedNumber(9,18);
    listaton.add(nby);

    DesignedNumber nbu = new DesignedNumber(5,-270);
    listaton.add(nbu);

    DesignedNumber nbi = new DesignedNumber(30,36);
    listaton.add(nbi);

    DesignedNumber nbo = new DesignedNumber(10,-162);
    listaton.add(nbo);

    DesignedNumber nbp = new DesignedNumber(8,-126);
    listaton.add(nbp);

    DesignedNumber nbas = new DesignedNumber(2,-9);
    listaton.add(nbas);

    DesignedNumber nbs = new DesignedNumber(35,-27);
    listaton.add(nbs);

    DesignedNumber nbd = new DesignedNumber(5,90);
    listaton.add(nbd);

    DesignedNumber nbf = new DesignedNumber(17,-279);
    listaton.add(nbf);
    DesignedNumber nbfn = new DesignedNumber(6,279);
    listaton.add(nbfn);
//    DesignedNumber nbff = new DesignedNumber(5,3);
//    listaton.add(nbff);
//    DesignedNumber nbgf = new DesignedNumber(5,3);
//    listaton.add(nbgf);

  DesignedNumber nbrq = new DesignedNumber(1,171);
  listaton.add(nbrq);

   DesignedNumber nbtz = new DesignedNumber(33,-63);
   listaton.add(nbtz);

   DesignedNumber nbyx = new DesignedNumber(19,243);
   listaton.add(nbyx);

   DesignedNumber nbuf = new DesignedNumber(31,-108);
   listaton.add(nbuf);
    DesignedNumber nbufz = new DesignedNumber(11,-315);
    listaton.add(nbufz);

   DesignedNumber nbiw = new DesignedNumber(15,126);
   listaton.add(nbiw);

   DesignedNumber nbor = new DesignedNumber(4,-45);
   listaton.add(nbor);

   DesignedNumber nbprt = new DesignedNumber(20,63);
   listaton.add(nbprt);

   DesignedNumber nbasy = new DesignedNumber(6,-90);
   listaton.add(nbasy);

   DesignedNumber nbsu = new DesignedNumber(16,-54);
   listaton.add(nbsu);

   DesignedNumber nbdi = new DesignedNumber(14,-18);
   listaton.add(nbdi);

   DesignedNumber nbfo = new DesignedNumber(31,-108);
   listaton.add(nbfo);


    DesignedNumber nbfoj = new DesignedNumber(24,144);
    listaton.add(nbfoj);
    DesignedNumber nbfojj = new DesignedNumber(29,-144);
    listaton.add(nbfojj);
   ///

   DesignedNumber nbyp = new DesignedNumber(28,9);
   listaton.add(nbyp);

   DesignedNumber nbup = new DesignedNumber(23,-36);
   listaton.add(nbup);

   DesignedNumber nbiss = new DesignedNumber(26,27);
   listaton.add(nbiss);

    DesignedNumber nbissz = new DesignedNumber(8,234);
    listaton.add(nbissz);

    DesignedNumber nbod = new DesignedNumber(12,225);
   listaton.add(nbod);
    DesignedNumber nbodcc = new DesignedNumber(24,-225);
    listaton.add(nbodcc);

   DesignedNumber nbpf = new DesignedNumber(3,135);
   listaton.add(nbpf);

   DesignedNumber nbasg = new DesignedNumber(34,108);
   listaton.add(nbasg);

   DesignedNumber nbsg = new DesignedNumber(10,198);
   listaton.add(nbsg);

   DesignedNumber nbdh = new DesignedNumber(7,54);
   listaton.add(nbdh);

   DesignedNumber nbfzz = new DesignedNumber(17,81);
   listaton.add(nbfzz);

    DesignedNumber nbfzzn = new DesignedNumber(6,-81);
    listaton.add(nbfzzn);
   DesignedNumber nbyxx = new DesignedNumber(18,-99);
   listaton.add(nbyxx);

   DesignedNumber nbucc = new DesignedNumber(19,-117);
   listaton.add(nbucc);

   DesignedNumber nbiv = new DesignedNumber(0,0);
   listaton.add(nbiv);

   DesignedNumber nbocvv = new DesignedNumber(00,180);
   listaton.add(nbocvv);

    DesignedNumber nbocv = new DesignedNumber(00,-180);
    listaton.add(nbocv);

   DesignedNumber nbpb = new DesignedNumber(22,99);
   listaton.add(nbpb);

   DesignedNumber nbasbv = new DesignedNumber(34,-252);
   listaton.add(nbasbv);

   DesignedNumber nbsxv = new DesignedNumber(11,45);
   listaton.add(nbsxv);


}


public  int getNumberByAngle (int resultAngle)
{
for (DesignedNumber d : listaton)
{
    if (d.getAngle()==resultAngle)
    {return d.getNumber();}

}
   return 0;
}




}
