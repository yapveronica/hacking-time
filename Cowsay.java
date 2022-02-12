public class Cowsay {
    private static void listCows(Cow[] cows) {
        int i;
        System.out.print("Cows available:");
        for (i = 0; i < cows.length; i++) {
            System.out.print(" " + cows[i].getName());
        }
    }
    private static Cow findCow(String name, Cow[] cows) {
        int i;
        for (i = 0; i < cows.length; i++) {
            if (cows[i].getName().equals(name)) {
                return cows[i];
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Cow[] cows = HeiferGenerator.getCows();

        if (args[0].equals("-l")) {     //  Lists cows
            listCows(cows);
        } else if (args[0].equals("-n")) {      // Finds specific cow
            Cow cow = findCow(args[1], cows);

            if (cow == null) {
                System.out.println("Could not find " + args[1] + " cow!");
            }
            else {
                for (int i = 2; i < args.length; i++) {     // Print out the message(s)
                    System.out.print(args[i] + " ");
                }

                if (args[1].equals("dragon")) {
                    System.out.println(findCow(args[1],cows).getImage());
                    boolean canBreatheFire = ((Dragon)cow).canBreatheFire();
                    if (canBreatheFire) {
                        System.out.println("This dragon can breathe fire.");
                    }
                }
                else if (args[1].equals("ice-dragon")) {
                    System.out.println(findCow(args[1],cows).getImage());
                    boolean canBreatheFire = ((Dragon)cow).canBreatheFire();
                    if (!canBreatheFire) {
                        System.out.println("This dragon cannot breathe fire.");
                    }
                }
                else {
                    System.out.println(findCow(args[1],cows).getImage()); //  Print out the cow
                }
            }

        } else {        // Default cow
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i] + " ");
            }
            System.out.println();
            System.out.println(cows[0].getImage());
        }
    }
}
