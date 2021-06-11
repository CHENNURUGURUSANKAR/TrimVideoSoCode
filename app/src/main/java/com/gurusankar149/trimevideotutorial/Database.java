package com.gurusankar149.trimevideotutorial;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;

public class Database {
    public static ArrayList<File> allVideoList = new ArrayList<>();
    public static File directory;
    public static String[] allpath;
    public static void loadAllVideos(Context context, final MycompleteListener mycompleteListener) {
        allpath = StorageUtil.getStorageDirectories(context);
        for (String path : allpath) {
            directory = new File(path);
            Method.loadDirectory(directory);
        }
        mycompleteListener.OnSuccess();
    }

}
