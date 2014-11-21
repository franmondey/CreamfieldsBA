package com.franmondey.creamfields2014.util;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;

import com.franmondey.creamfields2014.R;
import com.franmondey.creamfields2014.Dj;

import java.util.ArrayList;
import java.util.List;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by mikepenz on 18.10.14.
 */
public class UploadHelper {
    private static UploadHelper instance = null;


    private UploadHelper(ActionBarActivity act, List<Dj> dj) {
        this.act = act;

        if (dj != null) {
            this.dj = dj;
        } else {
            this.dj = new ArrayList<Dj>();
        }
    }

    private ActionBarActivity act;
    private List<Dj> dj = new ArrayList<Dj>();

    public static UploadHelper getInstance(ActionBarActivity act, List<Dj> applicationList) {
        if (instance == null) {
            instance = new UploadHelper(act, applicationList);
        } else if (act != null) {
            instance.act = act;
        }
        return instance;
    }

    public void upload(Dj dj) {
        new UploadComponentInfoTask().execute(dj);
    }

    public void uploadAll() {
        new UploadComponentInfoTask().execute();
    }

    private class UploadComponentInfoTask extends AsyncTask<Dj, Integer, Boolean> {
        ProgressDialog mProgressDialog = new ProgressDialog(act);

        @Override
        protected void onPreExecute() {
            if (!Network.isAvailiable(act)) {
                this.cancel(true);

                Crouton.showText(act, R.string.dialog_nointernet, Style.ALERT);
            } else {
                mProgressDialog.setTitle(R.string.dialog_uploading);
                mProgressDialog.setMessage(act.getString(R.string.dialog_processinganduploading));
                mProgressDialog.setIndeterminate(false);
                mProgressDialog.setCancelable(false);
                mProgressDialog.setMax(dj.size());
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.show();
            }

            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Dj... params) {
            boolean updateRequired = false;
            if (params == null || params.length == 0) {
                mProgressDialog.setMax(dj.size());

                for (Dj ai : dj) {
                    updateRequired = postData();
                    publishProgress(mProgressDialog.getProgress() + 1);
                    if (updateRequired) {
                        break;
                    }
                }
            } else if (params.length == 1) {
                updateRequired = postData();
                publishProgress(dj.size());
            }

            return updateRequired;
        }

        @Override
        protected void onPostExecute(Boolean updateRequired) {
            mProgressDialog.dismiss();
            super.onPostExecute(updateRequired);
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            if (values.length > 0) {
                mProgressDialog.setProgress(values[0]);
            }
            super.onProgressUpdate(values);
        }

    }

    public boolean postData() {

        try {
            Thread.sleep(150);
        } catch (Exception ex) {

        }

        return false;
    }
}
