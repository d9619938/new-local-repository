package com.local.project.lesson17;

import java.util.*;

public class Lesson17 {
    public static void main(String[] args) {
        // Map
        // ����� ���� String
        // �������� ���� Integer

        HashMap<String, Integer> customers = new HashMap<>();
        customers.put("������", 790);
        customers.put("������", 250);
        customers.put("��������", 790);
        customers.put("������", 300); // ���� ��� ����, ���������� ���������� ��������
        customers.put("������", 630);
        customers.put("�������", null);
        customers.put(null, 630);


        System.out.println(customers.size());    // 5
        System.out.println(customers.isEmpty()); // false

        customers.remove(null); // �������� ���� �� �����
       // customers.remove("������", 300); // ������ ������ ���� � ���� ���������� ���� "������ : 300"
        System.out.println(customers.remove("������", 300));  // ������ true
        System.out.println(customers.remove("������", 630));  // ������ true

        customers.replace("������", 1200); // ���� ������ ���������, �� ������ ������ �������� 630 (null, ���� ������ ��������)
        customers.replace("������", 790, 840); // ������� ��������, ���� � ���� ���������� ����:
        // "������ : 790", ������ TRUE

        // ��������� �������� �� ����� (�� ��������)
        System.out.println(customers.get("������")); // ������ 840
        System.out.println(customers.get("���")); // ������ null, ���� � ���� �������� null
        System.out.println(customers.get(null));  // null, ���� ���� null
        System.out.println(customers.get("�������"));  // null, ���� ���� null

        System.out.println(customers.getOrDefault("������", -1)); // ���������� ��������� ��������, ����
        // ���� �������� � ���� �����������
        System.out.println(customers.getOrDefault("���", -1));

        Integer spbValue = customers.getOrDefault("���", -1);
        if (spbValue == -1) {
            System.out.println("�� ������� �������� ���������� �� ���");
        }

        if (customers.containsKey("������")) {
            System.out.println("���������� � ������� ��� ����������");
        }

        if (customers.containsValue(1000)) {
            System.out.println("�������� 1000 ���������� � ����");
        }

        // ��������� ��������
        Collection<Integer> customersValue = customers.values();
        // ��������� ������
        Set<String> customersKeys = customers.keySet();
        // ��������� ��� (���� ��������)
        Set<Map.Entry<String, Integer>> customersPairs = customers.entrySet();
        for (Map.Entry<String, Integer> customersPair : customersPairs) {
            System.out.println(customersPair.getKey());
            System.out.println(customersPair.getValue());
//            if (customersPair.getValue() > 1000) {
//                System.out.println("� ������ " + customersPair.getKey() + " ���������� ����������� ������ 1000");
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
        EnumSet<ClientAuthData.Role> rolesEmpty = EnumSet.noneOf(ClientAuthData.Role.class); // ��� ������ new....�.�. ����� �����������
        rolesEmpty.add(ClientAuthData.Role.ADMIN);
        rolesEmpty.add(ClientAuthData.Role.MODERATOR);
        EnumSet<ClientAuthData.Role> roleEx = EnumSet.complementOf(EnumSet.of(ClientAuthData.Role.USER));
        EnumSet<ClientAuthData.Role> fromTo01 = EnumSet.range(ClientAuthData.Role.ADMIN, ClientAuthData.Role.MODERATOR);  // ������� ����� ��������
        EnumSet<ClientAuthData.Role> fromTo02 = EnumSet.range(ClientAuthData.Role.values()[0], ClientAuthData.Role.MODERATOR);// ����� ���������� � �� �������� Enuma

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

//    �������� static �����, ������� ��������� �� ����
//    EnumMap<ClientAuthData.Role, List<ClientAuthData>> map
//    � ���������� Map<Sting, String> c ������ userName - password
//    � �������������� Map ������ ������� userName � password
//    ������������� (ClientAuthData.Role.USER)

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
