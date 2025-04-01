import java.util.Scanner;

public class ObjInputTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(in);

        String id = sio.getNonZeroLenString("Enter your ID");
        String a = sio.getRegExString("Enter your phone number", "xxx - xxx - xxxx");
        int b = sio.getInt("Enter your age");
        int c = sio.getRangedInt("Enter your age", 0, 100);
        double d = sio.getDouble("How much does an apple cost");
        double e = sio.getRangedDouble("How much does a bananna cost", 1.24, 3.35);
        boolean f = sio.getYNConfirm("Are you done?");

        System.out.println(id);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }
}
