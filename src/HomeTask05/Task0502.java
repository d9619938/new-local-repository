package HomeTask05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Task0502 {
    /*Задача #2
Создать два массива целых чисел на 5 элементов каждый. Массивы необходимо заполнять значениями в цикле.
Значения вводит пользователь с клавиатуры.

Если число отрицательное, добавить его в первый массив.
Если число положительное, добавить его во второй массив.
Программа завершает работу, когда оба массива заполнены или, если пользователь ввёл 0*/
    public static void main(String[] args) {
        int count = 3;
        int[] arr01 = new int[count];
        int[] arr02 = new int[count];
        int start01 = 0;
        int end01 = count - 1;
        int start02 = 0;
        int end02 = count - 1;
        Scanner sc = new Scanner(System.in);


        while (!(start01 == count) && !(start02 == count)) {
                int value = sc.nextInt();
                if (value < 0 && start01 < count) {
                    arr01[start01] = value;
                    start01++;
                } else if (value > 0 && start02 < count) {
                    arr02[start02] = value;
                    start02++;
                }
                if (value == 0) {
                    break;
            }
        }
        System.out.println(Arrays.toString(arr01));
        System.out.println(Arrays.toString(arr02));

    }
}


//        int indexArr01 = 0;
//        int indexArr02 = 0;
//        Scanner scanner = new Scanner(System.in);
//        int value = 0;
//        for (int i = 0; i < arr01.length; i++) {
//            if ((value = scanner.nextInt()) < 0)
//                arr01[i] = value;
//            else if (value == 0) {
//                scanner.next();
//                break;
//            }
//        }
//        if (value == 0) {
////            break;
//        } else {
//            for (int i = 0; i < arr02.length; i++) {
//                if ((value = scanner.nextInt()) < 0)
//                    arr02[i] = value;
//                else if (value == 0) {
//                    break;
//                }
//
//            }
//        }
//        System.out.println(Arrays.toString(arr01));
//            System.out.println(Arrays.toString(arr02));
//    }
//}


//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            int value = sc.nextInt();
//            if (value == 0) {
//                break;
//            }
//            if (value < 0) {
//                    if (arr01[indexArr01] == 0) {
//                        arr01[indexArr01] = value;
//                        sc.next();
//                        if (indexArr01 <= count-1)
//                            indexArr01++;
//                    }
//            } else {
//                if (arr02[indexArr02] == 0) {
//                    arr02[indexArr02] = value;
//                    sc.next();
//                    if (indexArr02 <= count-1)
//                    indexArr02++;
//                }
//                }
//            System.out.println(Arrays.toString(arr01));
//            System.out.println(Arrays.toString(arr02));
//            }
//        }
//    }


//        while (liveArr01 && liveArr02) {
//
//            if (indexArr01 == arr01.length) {
//                continue;
//            } else if (value < 0) {
//                arr01[indexArr01] = value;
//                indexArr01++;
//            }
//            if (indexArr02 == arr02.length) {
//                continue;
//            } else if (value > 0) {
//                arr02[indexArr02] = value;
//                indexArr02++;
//            }
//        }
//        System.out.println(Arrays.toString(arr01));
//        System.out.println(Arrays.toString(arr02));
//    }
