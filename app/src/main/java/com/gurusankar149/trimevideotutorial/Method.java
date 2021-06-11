package com.gurusankar149.trimevideotutorial;

import android.util.Log;

import java.io.File;

public class Method {
    public static void loadDirectory(File Directory) {
        File[] filelist = Directory.listFiles();
        if (filelist != null && filelist.length > 0) {
            for (int i = 0; i < filelist.length; i++) {
                if (filelist[i].isDirectory()) {
                    loadDirectory(filelist[i]);
                }
                else{
                    String name=filelist[i].getName().toString().toLowerCase();
                    for (String extension: MethodExtension.videoExtension){
                        if (name.endsWith(extension)) {
                            Database.allVideoList.add(filelist[i]);
                            Log.d("Video List",name);
                            break;
                        }
                    }
                }
            }
        }
    }
}
