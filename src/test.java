import java.util.Random;
import java.util.Scanner;

/**
 * Created by cbaily on 4/11/17.
 */
public class test {
    public static void main(String[] args) {
        /*
         * Part 1 - prompt user for a string input of ASCII characters. Encode
		 * the string into a list of integers.
		 *
		 * This section has been completed for you.
		 */
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the message you would like to encode, using any ASCII characters: ");
        String input = keyboard.nextLine();
        int[] ASCIIvalues = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            ASCIIvalues[i] = input.charAt(i);
        }
        String ASCIInumbers = "";
        for (int j = 0; j < ASCIIvalues.length; j++) {
            ASCIInumbers += ASCIIvalues[j] + " ";
        }
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("The ASCII coded sequence is:");
        System.out.println();
        System.out.println(ASCIInumbers);
        System.out.println();
        System.out.println("-----------------------------------------");

        long P = bigPrime();
        long Q = P;
        while (Q == P) {
            Q = bigPrime();
        }
        // Print the results here.
        System.out.println();
        System.out.println("The two primes are P = " + P + " and Q = " + Q);
        System.out.println();
        System.out.println("The product of the two primes, P*Q, is the modulus for both the private");
        System.out.println("and public key and is thus part of the public domain: " + P * Q);
        System.out.println("Something interesting to note about how this algorithm works is that");
        System.out.println("while P*Q is public, factoring very large numbers is very difficult");
        System.out.println("computationally, so only the person with the knownledge of the");
        System.out.println("individual values P and Q, has the tools to derive the private key.");
        System.out.println();
        System.out.println("-----------------------------------------");

		/*
         * Part 3 - Next, we calculate the public key exponent, called E. E is
		 * chosen to be an integer which is relatively prime to another integer
		 * called the totient, usually represented by phi. In this step,
		 * calculate phi, which is equal to (P-1)(Q-1). The create a public key
		 * exponent, create an integer E that is relatively prime to phi, and
		 * also less than phi.
		 *
		 * THIS SECTION HAS NOT BEEN COMPLETED FOR YOU.
		 */

        // calculate phi here
        ////////////////////////////////////////////////
        long phi = (P - 1) * (Q - 1);
        // write an algorithm to find E which is relatively prime to phi here.
        // in other words find E such that gcd(phi,E)=1, and E<phi.
        long E = 2;
        while (true) {
            if (gcd(E, phi) == 1 && E < phi) {
                break;
            } else
                E++;
        }
        ///////////////////////////////////////////////

        System.out.println();
        System.out.println("The totient is phi = " + phi);
        System.out.println("and");
        System.out.println("The public key is E = " + E);
        System.out.println();
        System.out.println("-----------------------------------------");}

		/*
         * Part 4 - Find the multiplicative inverse of E mod (P-1)(Q-1). In this
		 * step, we are looking for D such that E*D = 1 mod phi. Remember, phi
		 * is called the totient and is equal to (P-1)(Q-1). To do this, we need
		 * to find what are called the Bezout coefficients of E and phi. The
		 * algorithm to get these numbers is called the 'extended euclidean
		 * algorithm.' In part 4, you used the gcd function from a built-in
		 * library to make sure that the GCD of the integer you generated and
		 * phi is 1. [ie gcd(phi,E) = 1 ]. Now, because we know gcd(phi,E)=1,
		 * then we proved in class that there MUST exist coefficients x and y
		 * such that x*phi + y*E = 1. These coefficients are called the Bezout
		 * coefficients, and the extended euclidean algorithm we practiced in
		 * class finds them. The very important thingto notice about the Bezout
		 * coefficient y is that it must also be the multiplicative inverse of E
		 * (mod phi). Note: if x*phi + y*E = 1, then y*E = 1 - x*phi, which
		 * means y*E = 1 mod phi. In this next section, you should write the
		 * first part of the extended Euclidean algorithm, which will confirm
		 * that gcd(E,phi)=1, and will also generate a list of remainders and
		 * quotients which will be needed to perform the second part of the EA
		 * (see pdf on collab). Next, write the second part of the extended
		 * euclidean algorithm, which returns the bezout coefficients to find
		 * the multiplicative inverse of E (mod phi). We will call that inverse
		 * D, and D is called the PRIVATE KEY EXPONENT, and should only be known
		 * by the person to whom the message is being sent.
		 *
		 * THIS SECTION HAS NOT BEEN COMPLETED FOR YOU.
		 */

        //Write your code for the Euclidean Algorithm Here.

        //////////////////////////////////////////////

        //Next, begin the second part of the euclidean algorithm, where you substitute
//your way back up the algorithm to find the multiplicative inverse of E.

        ////////////////////////////////////////////////

        //Display results

    public static int bigPrime() {
        boolean prime = false;
        int n = 0;
        while (!prime) {
            Random rand = new Random();
            n = rand.nextInt(500);
            n = 2 * (n + 500) + 1;
            int sqrtn = (int) Math.pow(n, 0.5) + 1;
            for (int i = 3; i < sqrtn; i += 2) {
                if (n % i == 0) {
                    prime = false;
                    break;
                } else {
                    prime = true;
                }
            }
        }
        return n;
    }

    // Method to compute the GCD of two positive integers.
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}


