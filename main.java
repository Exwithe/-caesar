import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        while (true) {
            int key = key();
            char[] code = input();
            if (key != 0) {
                encode(key, code);
            } else {
                decode(code);
            }
        }
    }

    public static int key() {
        int key;
        System.out.println("Enter your 2-number key!");
        Scanner scanner = new Scanner(System.in);
        boolean hasNextInt = scanner.hasNextInt();
        if (hasNextInt) {
            key = scanner.nextInt();
            if (key < 26 && key > -1) {
                System.out.println("Your key is " + key);
                return key;
            } else {
                System.out.println("Only numbers from 1 up to 25");
                System.out.println("If you wanna decode enter '0'");
                key();
                return 0;
            }
        } else {
            System.out.println("Invalid input");
            key();
            return 0;
        }
    }

    public static char[] input() {
        String inputArray;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your code");
        inputArray = scanner.nextLine().toLowerCase();
        char[] code = inputArray.toCharArray();
        return code;
    }


    public static void encode(int key, char[] code) {
        for (int i = 0; i < code.length; i++) {
            if (code[i] < 123 && code[i] > 96) {
                if (code[i] + key < 123 && code[i] + key > 96) {
                    code[i] += key;
                } else {
                    code[i] += key - 26;
                }
            }
            System.out.print(code[i]);
        }
        System.out.println("\n");
        System.out.println("key " + key);
        System.out.println("\n");
    }

    public static void decode(char[] originalCode) {
        char[] code = originalCode;
        double maxResult = 0;
        double result = 0;
        int maxkey = 0;
        for (int key = 25; key > -1; key--) {
            for (int i = 0; i < code.length; i++) {
                if (code[i] > 63 && code[i] < 123) {
                    code[i]--;
                    if (code[i] < 97) {
                        code[i] += 26;
                    }
                    switch (code[i]) {
                        case 'e':
                            result += 17.4;
                            break;
                        case 'n':
                            result += 9.78;
                            break;
                        case 'i':
                            result += 7.55;
                            break;
                        case 's':
                            result += 7.27;
                            break;
                        case 'r':
                            result += 7.00;
                            break;
                        case 'a':
                            result += 6.51;
                            break;
                        case 't':
                            result += 6.15;
                            break;
                        case 'd':
                            result += 5.08;
                            break;
                        case 'h':
                            result += 4.76;
                            break;
                        case 'u':
                            result += 4.35;
                            break;
                        case 'l':
                            result += 3.44;
                            break;
                        case 'c':
                            result += 3.06;
                            break;
                        case 'g':
                            result += 2.51;
                            break;
                        case 'm':
                            result += 1.89;
                            break;
                        case 'o':
                            result += 1.89;
                            break;
                        case 'b':
                            result += 1.21;
                            break;
                        case 'w':
                            result += 1.66;
                            break;
                        case 'f':
                            result += 1.21;
                            break;
                        case 'k':
                            result += 1.13;
                            break;
                        case 'z':
                            result += 0.79;
                            break;
                        case 'p':
                            result += 0.67;
                            break;
                        case 'v':
                            result += 0.31;
                            break;
                        case 'j':
                            result += 0.27;
                            break;
                        case 'y':
                            result += 0.04;
                            break;
                        case 'x':
                            result += 0.03;
                            break;
                        case 'q':
                            result += 0.02;
                            break;
                    }
                }
            }
            if (result > maxResult) {
                maxResult = result;
                maxkey = key;
            }
            result = 0;
        }
        encode(maxkey, originalCode);
    }
}


