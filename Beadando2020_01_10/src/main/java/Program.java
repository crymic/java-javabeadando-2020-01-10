import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

// @author Vicu
public class Program 
{
    static ArrayList<Felfedezes> felfedezesek = new ArrayList<>();
    static String be_vegyjel = null;
    static BufferedReader br_vegyjel = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) 
    {
        Beolvasas();
        Feladat3();
        Feladat4();
        Feladat5();
        Feladat6();
        Feladat7();
        Feladat8();
        
    }

    private static void Beolvasas() 
    {
        try
        {
            File file = new File("C:/Users/Vicu/source/repos/Beadando_Java_2/Beadando_Java_2/bin/Debug/felfedezesek2.txt");
            BufferedReader br = new BufferedReader(
		   new InputStreamReader(
                      new FileInputStream(file), "UTF8"));
            String sor;
            br.readLine();
            while((sor=br.readLine()) != null)
            {
                felfedezesek.add(new Felfedezes(sor));
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("asd");
        }
    }

    private static void Feladat3() {
        System.out.println("3. Feladat: elemek száma:" + felfedezesek.size());
    }

    private static void Feladat4() {
        int sum = 0;
        for (int i = 0; i < felfedezesek.size(); i++) {
            if (felfedezesek.get(i).Ev_String() != null) {
                sum++;
            }
        }
        System.out.println("Feladat 4: felfedezések száma az ókorban: " + sum);
    }

    private static void Feladat5() {
        System.out.println("Kérek egy elemet:");
        
        boolean van = false;
        while (van != true)
        {
            try
            {
                be_vegyjel = br_vegyjel.readLine();
                if (van == false) 
                {
                    for (int i = 0; i < felfedezesek.size(); i++) 
                    {
                        if (felfedezesek.get(i).Vegyjel().toLowerCase().equals(be_vegyjel.toLowerCase())) {
                            van = true;
                        }
                    }
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
            
        }
    }

    private static void Feladat6() {
        for (int i = 0; i < felfedezesek.size(); i++) {
            if (felfedezesek.get(i).Vegyjel().toLowerCase().equals(be_vegyjel.toLowerCase())) {
                System.out.println("6. Feladat: Keresés");
                System.out.println("\tAz elem vegyjele: " + felfedezesek.get(i).Vegyjel());
                System.out.println("\tAz elem neve: " + felfedezesek.get(i).Nev());
                System.out.println("\tRendszáma: " + felfedezesek.get(i).Rendszam());
                System.out.print("\tA felfedezés éve: ");
                if (felfedezesek.get(i).Ev_Int() == 0) {
                    System.out.print(felfedezesek.get(i).Ev_String());}
                else
                    System.out.print(felfedezesek.get(i).Ev_Int());
                System.out.println("\n\tA felfedező: " + felfedezesek.get(i).Felfedezo());
            }
        }
    }

    private static void Feladat7() {
        ArrayList<Integer> kulonbsegek = new ArrayList<>();
        int ossz = 0;
        for (int i = 0; i < felfedezesek.size() - 1; i++) {
            if (felfedezesek.get(i).Ev_Int() != 0) {
                ossz++;
                kulonbsegek.add(felfedezesek.get(i).Ev_Int() - felfedezesek.get(i + 1).Ev_Int());
            }
        }
        for (int i = 0; i < kulonbsegek.size(); i++) {
            if (kulonbsegek.get(i) < 0) {
                kulonbsegek.set(i, kulonbsegek.get(i) * -1);
            }
        }
        int max = 0;
        for (int i = 0; i < kulonbsegek.size(); i++) {
            if (kulonbsegek.get(i) > max) {
                max = kulonbsegek.get(i);
            }
        }
        System.out.println("A legtöbb eltelt év két elem között: " + max);
    }

    private static void Feladat8() {
        ArrayList<Integer> valogatott_evek_l = new ArrayList<>();
        ArrayList<Integer> valogatott_evek_db_l = new ArrayList<>();
        int valogatottaktsum = 0;
        int x = 0;
        
        for (int i = 0; i < felfedezesek.size(); i++) {
            int szamlalo = 0;
            x = 0;
            for (; x < felfedezesek.size(); x++) {
                if (felfedezesek.get(i).Ev_Int() == felfedezesek.get(x).Ev_Int() && felfedezesek.get(i).Ev_Int() != 0 && !valogatott_evek_l.contains(felfedezesek.get(x).Ev_Int())) {
                    szamlalo++;
                    if (szamlalo >= 4) {
                        valogatott_evek_l.add(felfedezesek.get(x).Ev_Int());
                    }
                }
            }
        }
        for (int i = 0; i < valogatott_evek_l.size(); i++) {
            valogatottaktsum = 0;
            for (int j = 0; j < felfedezesek.size(); j++) {
                if (valogatott_evek_l.get(i) == felfedezesek.get(j).Ev_Int()) {
                    valogatottaktsum++;
                }
            }
            valogatott_evek_db_l.add(valogatottaktsum);
        }
        for (int i = 0; i < valogatott_evek_l.size(); i++) {
            System.out.println(valogatott_evek_l.get(i) + " " + valogatott_evek_db_l.get(i) + "db ");
        }
    }
}
