package com.local.project.lesson29;

import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveTask;

//Future
//ForkJoinTask
//RecursiveTask<return type> | RecursiveAction
public class FileFinder extends RecursiveTask<File> /* RecursiveAction*/ {
//    ищим фаил п имени, ели файл есть, то возвращаем абсолютный путь
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
    protected File compute() {  // метод compute или action зависит от чего экстендимся
        File[] subFiles = directory.listFiles();
        CopyOnWriteArrayList<FileFinder> fileFinders = new CopyOnWriteArrayList<>();
        if (subFiles != null) {
            for (File subFile : subFiles) {
                if (subFile.isDirectory()) {
                    FileFinder subFinder = new FileFinder(file, subFile); // если основной поток сталкивается с подзадачей, то создаем отдельную задачу
                    subFinder.fork(); // поместить новый поток в очередь
                    fileFinders.add(subFinder);
                } else {
                    if (file.getName().equals(subFile.getName())) { // если поток доходит до файлов, то сравнивает имя
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
