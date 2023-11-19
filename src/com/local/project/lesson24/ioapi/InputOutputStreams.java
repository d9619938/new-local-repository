package com.local.project.lesson24.ioapi;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class InputOutputStreams {
    public static void input(){
        /*try (InputStream inputStream = *//* входящий поток, наследник InputStream*//*){
            // 1. чтение в массив bytes01, возвращает количество прочитанных байт
            byte[] bytes01 = new byte[inputStream.available()];
            inputStream.read(bytes01);

            // 2. чтение в массив bytes02 len байт с отступом offset, возвращает количество прочитанных байт
            // прочитанные байты записываются в динамический массив
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream(); // динамический массив для накопления данных
            byte[] bytes02 = new byte[512];
            int data;

            while ((data = inputStream.read(bytes02)) != -1) {
                byteArray.write(bytes02, 0, data);
            }

            // 3. возвращает прочитанный байт
            int readByte = inputStream.read();
        } catch (IOException e) {
            System.out.println("во время чтения произошла ошибка"); // или
            System.out.println("во время закрытия ресурса произошла ошибка");
        }*/
    }




    public static void inputDecorator(){
        // основной функционал
        /*try (InputStream inputStream = *//* входящий поток, наследник InputStream*//*;
             // дополнительный функционал, должен быть наследником FilterInputStream
             BufferedInputStream bufferedInput = new BufferedInputStream(inputStream)){

            // 1. чтение в массив bytes01, возвращает количество прочитанных байт или -1
            byte[] bytes01 = new byte[inputStream.available()];
            bufferedInput.read(bytes01);

            // 2. чтение в массив bytes02 len байт с отступом offset, возвращает количество прочитанных байт или -1
            // прочитанные байты записываются в динамический массив
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream(); // динамический массив для накопления данных
            byte[] bytes02 = new byte[512];
            int data;

            while ((data = bufferedInput.read(bytes02)) != -1) {
                byteArray.write(bytes02, 0, data);
            }

            // 3. возвращает прочитанный байт или -1
            int readByte = bufferedInput.read();

        } catch (IOException e) {
            System.out.println("во время чтения произошла ошибка"); // или
            System.out.println("во время закрытия ресурса произошла ошибка");
        }*/
    }

    public static void output(byte[] bytesWithData){
        /*try (OutputStream outputStream = *//* исходящий поток, наследник OutputStream*//*){
            // 1. записывает байты из bytesWithData в поток
            outputStream.write(bytesWithData);

            // 2. записывает len байт из bytesWithData в поток с отступом offset
            outputStream.write(bytesWithData, 0, bytesWithData.length / 2);

            // 3. записывает один байт в поток
            outputStream.write(bytesWithData[0]);
        } catch (IOException e) {
            System.out.println("во время записи произошла ошибка"); // или
            System.out.println("во время закрытия ресурса произошла ошибка");
        }*/
    }

    public static void outputDecorator(byte[] bytesWithData){
        class AppOutputDecorator extends FilterOutputStream{
            public AppOutputDecorator(OutputStream out) {
                super(out);
            }
            @Override
            public void write(int b) throws IOException {
                // операции с данными, например, шифрование, передача преобразованных данных дальше
                super.write(b);
            }
        }

        // основной функционал
        /*try (OutputStream outputStream = *//* исходящий поток, наследник OutputStream*//*;
             // дополнительный функционал, должен быть наследником FilterOutputStream
             AppOutputDecorator decorator = new AppOutputDecorator(outputStream)){
            // 1. записывает байты из bytesWithData в поток
            decorator.write(bytesWithData[0]);

            // 2. записывает len байт из bytesWithData в поток с отступом offset
            decorator.write(bytesWithData, 0, bytesWithData.length / 2);

            // 3. записывает один байт в поток
            decorator.write(bytesWithData[0]);
        } catch (IOException e) {
            System.out.println("во время записи произошла ошибка"); // или
            System.out.println("во время закрытия ресурса произошла ошибка");
        }*/
    }
}