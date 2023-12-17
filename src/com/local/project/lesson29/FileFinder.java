package com.local.project.lesson29;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveTask;

// «јƒј„ј ƒЋя ForkJoinPool
//Future
//ForkJoinTask
//RecursiveTask<return type> | RecursiveAction
public class FileFinder extends RecursiveTask<File> /* RecursiveAction*/ {
//    ищем файл по имени в определенной директории, если файл есть, то возвращаем абсолютный путь к файлу
    private File file;
    private File directory;

public FileFinder(File file, File directory) {
    if (file == null) throw new IllegalArgumentException("file is null");
    this.file = file;
    if (directory == null || !directory.isDirectory())
        throw new IllegalArgumentException("error in directory");
    this.directory = directory;

}

    @Override
    protected File compute() {  // метод compute или action зависит от чего экстендимс€
        File[] subFiles = directory.listFiles();
//        CopyOnWriteArrayList<FileFinder> fileFinders = new CopyOnWriteArrayList<>();  тут не нужна потокобезопастна€ коллекци€
        List<FileFinder> fileFinders = new ArrayList<>();
        if (subFiles != null) {
            for (File subFile : subFiles) {
                if (subFile.isDirectory()) {
                    FileFinder subFinder = new FileFinder(file, subFile); // если основной поток сталкиваетс€ с подзадачей, то создаем отдельную задачу
                    subFinder.fork(); // поместить новый поток в очередь
                    fileFinders.add(subFinder);
                } else {
                    if (file.getName().equals(subFile.getName())) { // если поток доходит до файлов, то сравнивает им€
                        // и возвращает абсолютный путь
                        return subFile.getAbsoluteFile();
                    }
                }
            }
    }
    for (FileFinder fileFinder : fileFinders) {
        File found = fileFinder.join();
        if (found != null && found.getName().equals(file.getName())){
            return found.getAbsoluteFile();
        }

    }return null;
    }
}
