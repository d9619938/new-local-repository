package com.local.project.lesson27.homeTask27.task02;

import java.util.*;
import java.util.stream.Collectors;

public class HomeTask27_2 {
    /*1. Даны 4 файла с текстовой информацией.
2. Строки в файлах имеют следующий вид: id::название-товара::стоимость-товара::количество-на-складе
3. Каждый файл должен обрабатываться в отдельном потоке.
4. Каждый поток читает информацию из файла и сохраняет её в объект, объект помещает в коллекцию.
5. После того как все потоки закончат работу со своими файлами, основной поток должен объединить информацию из отдельных
   коллекций в мапу (ключи - названия, значения - отсортированные по стоимости множества товаров).
6. Фоновый поток записывает в файл информацию о прочитанных товарах. Записываемая информация - id:количество-на-складе*/

   private static volatile Map<String, List<Product>> map = new HashMap<>();   // с множестврм не получилось... ошибка Class...

    public static void main(String[] args) {
        InfoFile infoFile01 = new InfoFile("infoFile01", "D:\\JAVA\\test\\Task27\\productfile01.txt");
        InfoFile infoFile02 = new InfoFile("infoFile02", "D:\\JAVA\\test\\Task27\\productfile02.txt");
        InfoFile infoFile03 = new InfoFile("infoFile03", "D:\\JAVA\\test\\Task27\\productfile03.txt");
        InfoFile infoFile04 = new InfoFile("infoFile04", "D:\\JAVA\\test\\Task27\\productfile04.txt");

        infoFile01.start();
        infoFile02.start();
        infoFile03.start();
        infoFile04.start();

        try {
            infoFile01.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            infoFile02.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            infoFile03.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            infoFile04.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }  // ожидание потоков

        //        TreeSet<Product> sortlist = infoFile01.getProductList().stream().sorted((x1, x2)-> Double.compare(x1.getPrice(), x2.getPrice())) // разобраться почему выдает ошибку
//                .collect(Collectors.toCollection(TreeSet::new));

        // сделаю без множества

        // хотел вынести в метод, чтобы не сорить в maine...но не смог передать поток в метод
        List<Product> list01 = infoFile01.getProductList().stream().sorted(Comparator.comparingDouble(Product::getPrice)).toList();
        List<Product> list02 = infoFile02.getProductList().stream().sorted(Comparator.comparingDouble(Product::getPrice)).toList();
        List<Product> list03 = infoFile03.getProductList().stream().sorted(Comparator.comparingDouble(Product::getPrice)).toList();
        List<Product> list04 = infoFile04.getProductList().stream().sorted(Comparator.comparingDouble(Product::getPrice)).toList();


        map.put(infoFile01.getFilename(), list01);
        map.put(infoFile02.getFilename(), list02);
        map.put(infoFile03.getFilename(), list03);
        map.put(infoFile04.getFilename(), list04);

        System.out.println(map);
        System.out.println();

        try {                                  // дадим больше фору фоновому потоку, для выполнения записи в map
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread thread = new Thread(() -> {
            Map<String, Integer> diamondMap = new HashMap<>();
            for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    String id = entry.getValue().get(i).getId();
                    int quantity = entry.getValue().get(i).getQuantity();
                    diamondMap.put(id, quantity);
                }
            }
            System.out.println(diamondMap);
        });
        thread.setDaemon(true);
        thread.start();

    }
//    private List<? extends Product> getlistProduct (<? super Thread> thread){                                 // разобраться почему метод не работает...что-то с передачей потока в параметры метода
//        return thread.getProductList().stream().sorted(Comparator.comparingDouble(Product::getPrice)).toList();
//    }

}
