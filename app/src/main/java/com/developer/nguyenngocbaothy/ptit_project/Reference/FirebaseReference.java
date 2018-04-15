package com.developer.nguyenngocbaothy.ptit_project.Reference;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

/**
 * Created by Lãng on 14/4/2018.
 */

public class FirebaseReference {

    final static String TAG = "FirebaseReference";

    public static void setImageFromFireBase(StorageReference mStorageRef, String prefix, String suffix, final ImageView img) {
        try {
            final File localFile = File.createTempFile(prefix, suffix);
            Log.d(TAG, "createTempFile: success!");
            mStorageRef.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            final Bitmap[] bitmap = new Bitmap[1];
                            Log.d(TAG, "setImageFromFireBase: success!");
                            bitmap[0] = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            img.setImageBitmap(bitmap[0]);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Log.e(TAG, "setImageFromFireBase: fail! " + exception.getMessage());
                }
            });
        } catch (IOException e) {
            Log.e(TAG, "createTempFile: fail! " + e.toString());
        }
    }
}
