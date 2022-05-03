package com.m3.c216.dvdLibrary.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{
    private final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return SCANNER.next();
    }

    @Override
    public String readStringLine(String prompt){
        SCANNER.nextLine();
        System.out.println(prompt);
        return SCANNER.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);

        while (true) {
            try {
                return SCANNER.nextInt();
            } catch (NumberFormatException ignored) {
                System.out.println("***Enter valid integer***");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.printf("%s between %d and %d inclusive %n", prompt, min, max);

        while (true) {
            try {
                int input = SCANNER.nextInt();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("***integer not in the specified range***");
                }
            } catch (NumberFormatException ignored) {
                System.out.println("***Enter valid integer***");
            }
        }
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);

        while (true) {
            try {
                return SCANNER.nextDouble();
            } catch (NumberFormatException ignored) {
                System.out.println("***Enter valid double***");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.printf("%s between %f and %f inclusive %n", prompt, min, max);

        while (true) {
            try {
                double input = SCANNER.nextDouble();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("***integer not in the specified range***");
                }
            } catch (NumberFormatException ignored) {
                System.out.println("***Enter valid double***");
            }
        }
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);

        while (true) {
            try {
                return SCANNER.nextFloat();
            } catch (NumberFormatException ignored) {
                System.out.println("***Enter valid float***");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        while (true) {
            try {
                float input = SCANNER.nextFloat();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("***integer not in the specified range***");
                }
            } catch (NumberFormatException ignored) {
                System.out.println("***Enter valid float***");
            }
        }
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);

        while (true) {
            try {
                return SCANNER.nextLong();
            } catch (NumberFormatException ignored) {
                System.out.println("***Enter valid long***");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        while (true) {
            try {
                long input = SCANNER.nextLong();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("***integer not in the specified range***");
                }
            } catch (NumberFormatException ignored) {
                System.out.println("***Enter valid long***");
            }
        }
    }
}
