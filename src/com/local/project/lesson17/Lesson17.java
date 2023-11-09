package com.local.project.lesson17;

import java.util.*;

public class Lesson17 {
    public static void main(String[] args) {
        // Map
        // ключи типа String
        // значения типа Integer

        HashMap<String, Integer> customers = new HashMap<>();
        customers.put("Москва", 790);
        customers.put("Ростов", 250);
        customers.put("Новгород", 790);
        customers.put("Ростов", 300); // ключ уже есть, произойдет перезапись значения
        customers.put("Самара", 630);
        customers.put("Анадырь", null);
        customers.put(null, 630);


        System.out.println(customers.size());    // 5
        System.out.println(customers.isEmpty()); // false

        customers.remove(null); // удаление пары по ключу
       // customers.remove("Ростов", 300); // удалит только если в мапе существует пара "Ростов : 300"
        System.out.println(customers.remove("Ростов", 300));  // вернет true
        System.out.println(customers.remove("Самара", 630));  // вернет true

        customers.replace("Самара", 1200); // если замена произошла, то вернет старое значение 630 (null, если нечего заменить)
        customers.replace("Москва", 790, 840); // заменит значение, если в мапе существует пара:
        // "Москва : 790", ВЕРНЕТ TRUE

        // получение значения по ключу (НЕ УДАЛЕНИЕ)
        System.out.println(customers.get("Москва")); // вернет 840
        System.out.println(customers.get("СПб")); // вернет null, если у пары значение null
        System.out.println(customers.get(null));  // null, если есть null
        System.out.println(customers.get("Анадырь"));  // null, если есть null

        System.out.println(customers.getOrDefault("Москва", -1)); // возвращает дефолтное значение, если
        // есть значение в мапе ОТСУТСТВУЕТ
        System.out.println(customers.getOrDefault("СПБ", -1));

        Integer spbValue = customers.getOrDefault("СПб", -1);
        if (spbValue == -1) {
            System.out.println("Не удалось получить информацию по СПБ");
        }

        if (customers.containsKey("Ростов")) {
            System.out.println("Информация о Ростове уже содержится");
        }

        if (customers.containsValue(1000)) {
            System.out.println("Значение 1000 содержится в мапе");
        }

        // коллекция значений
        Collection<Integer> customersValue = customers.values();
        // множество ключей
        Set<String> customersKeys = customers.keySet();
        // множество пар (ключ значение)
        Set<Map.Entry<String, Integer>> customersPairs = customers.entrySet();
        for (Map.Entry<String, Integer> customersPair : customersPairs) {
            System.out.println(customersPair.getKey());
            System.out.println(customersPair.getValue());
//            if (customersPair.getValue() > 1000) {
//                System.out.println("В городе " + customersPair.getKey() + " количество покупателей больше 1000");
//            }
        }

        EnumMap<ClientAuthData.Role, List<ClientAuthData>> clientsByRole = new EnumMap<>(ClientAuthData.Role.class);
        System.out.println(clientsByRole.size()); // 0
        clientsByRole.put(ClientAuthData.Role.USER, new ArrayList<>());
        clientsByRole.put(ClientAuthData.Role.ADMIN, new ArrayList<>());
        System.out.println(clientsByRole.size()); // 2
        ClientAuthData data01 = new ClientAuthData("qqq", "123", ClientAuthData.Role.USER);
        clientsByRole.get(ClientAuthData.Role.USER).add(data01);


        EnumSet<ClientAuthData.Role> rolesFull = EnumSet.allOf(ClientAuthData.Role.class);
        EnumSet<ClientAuthData.Role> rolesEmpty = EnumSet.noneOf(ClientAuthData.Role.class); // это вместо new....т.к. класс абстрактный
        rolesEmpty.add(ClientAuthData.Role.ADMIN);
        rolesEmpty.add(ClientAuthData.Role.MODERATOR);
        EnumSet<ClientAuthData.Role> roleEx = EnumSet.complementOf(EnumSet.of(ClientAuthData.Role.USER));
        EnumSet<ClientAuthData.Role> fromTo01 = EnumSet.range(ClientAuthData.Role.ADMIN, ClientAuthData.Role.MODERATOR);  // порядок имеет значение
        EnumSet<ClientAuthData.Role> fromTo02 = EnumSet.range(ClientAuthData.Role.values()[0], ClientAuthData.Role.MODERATOR);// можно обращаться и по индексам Enuma

        TreeMap<String, List<String>> students = new TreeMap<>();



    }
    private static ArrayList<String> getListOfCities(HashMap<String, Integer> hashMap, int max) {
        ArrayList list = new ArrayList();
        Set<Map.Entry<String, Integer>> hashMaps = hashMap.entrySet();
        for (Map.Entry<String, Integer> line : hashMaps){
            if (line.getValue() != null && line.getValue() < max){
                list.add(line.getKey());
            }
        }
        return list;
    }

    private static void go(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map,  ClientAuthData authData){
        ClientAuthData.Role key = authData.getRole();
        if (map.get(key) == null) {
        map.put(authData.getRole(), new ArrayList<>());
    }
    map.get(key).add(authData);
    }

//    написать static метод, который принимает на вход
//    EnumMap<ClientAuthData.Role, List<ClientAuthData>> map
//    и возвращает Map<Sting, String> c парами userName - password
//    в результирующий Map должны попасть userName и password
//    пользователей (ClientAuthData.Role.USER)

    private static Map<String, String> getUserbyRole(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map){
//        List<ClientAuthData> user =
        return null;
    }
//    public static Map<String,String> getUserByRole(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map){
//        List<ClientAuthData> user = map.get(ClientAuthData.Role.USER);
//        Map<String,String> users = new HashMap<>();
//        for (ClientAuthData client : user){
//            users.put(client.getUserName(),client.getPassword());
//        }
//        return users;
//    }
}
