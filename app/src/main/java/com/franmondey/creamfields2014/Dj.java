package com.franmondey.creamfields2014;


import android.content.Context;
import android.graphics.drawable.Drawable;

public class Dj {


    private Drawable icon = null;
    String name = null;
    String time = null;
    Context context;

    public Dj(Context cxt) {
        context = cxt;
    }

    public String getName(int i) {
        
        if (name == null) {
            this.name = djNames[i];
        }
        
        return name;
    } 
    
    public String getTime(int i) {
        
        if (time == null) {

            this.time = djTimes[i];
        }
        
        return name;
    }

    public Drawable getIcon() {

        if (icon == null) {
            icon = context.getResources().getDrawable(R.drawable.ic_launcher);
/*
Drawable dr = getResolveInfo().loadIcon(ctx.getPackageManager());
Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
icon = new BitmapDrawable(ctx.getResources(), AppHelper.getResizedBitmap(bitmap, 144, 144));
*/
        }
        return icon;
    }


/*    public String getActivityName() {
        return ri.activityInfo.name;
    }
    public String getPackageName() {
        return ri.activityInfo.packageName;
    }
    public ComponentName getComponentName() {
        return componentName;
    }
    public String getComponentInfo() {
        if (getComponentName() != null) {
            return getComponentName().toString();
        } else {
            return "";
        }
    }
    public ResolveInfo getResolveInfo() {
        return ri;
    }
    public PackageInfo getPackageInfo() {
        return pi;
    }
    public String getVersionName() {
        PackageInfo pi = getPackageInfo();
        if (pi != null) {
            return pi.versionName;
        } else {
            return "";
        }
    }
    public int getVersionCode() {
        PackageInfo pi = getPackageInfo();
        if (pi != null) {
            return pi.versionCode;
        } else {
            return 0;
        }
    }
    public Drawable getIcon() {
        if (icon == null) {
            icon = getResolveInfo().loadIcon(ctx.getPackageManager());
/*
Drawable dr = getResolveInfo().loadIcon(ctx.getPackageManager());
Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
icon = new BitmapDrawable(ctx.getResources(), AppHelper.getResizedBitmap(bitmap, 144, 144));
*/
/*        }
        return icon;
    }
    @SuppressLint("NewApi")
    public long getFirstInstallTime() {
        PackageInfo pi = getPackageInfo();
        if (pi != null && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            return pi.firstInstallTime;
        } else {
            return 0;
        }
    }
    @SuppressLint("NewApi")
    public long getLastUpdateTime() {
        PackageInfo pi = getPackageInfo();
        if (pi != null && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            return pi.lastUpdateTime;
        } else {
            return 0;
        }
    }
  */  
    private static String[] djNames = {
            "David Guetta",
            "Martin Garrix",
            "Dimitri Vegas &amp; Like Mike",
            "Hercules &amp; Love Affair",
            "Franco Cinelli &amp; Deep Mariano",
            "Silver City",
            "Leandro Fresco &amp; Gustavo Lamas",
            "Catnapp",
            "Rama",
            "Deep Dish",
            "Solomun",
            "Tale of Us",
            "The Martinez Brothers",
            "Hernan Cattaneo",
            "Felipe Venegas",
            "Deep Mariano",
            "Guille Quero",
            "Arty",
            "Fedde Le Grand",
            "Tommy Trash",
            "R3HAB",
            "Otto Knows",
            "Zuker",
            "Facu Carri",
            "Jay West",
            "HIIO",
            "Santiago Martinez",
            "Richie Hawtin",
            "Gaiser",
            "Maetrik",
            "Maya Jane Coles",
            "Dubfire",
            "Barem",
            "Franco Cinelli",
            "Brian Gros",
            "Miguel Silver",
            "Jorge Savoretti",
            "Mathias Kaden",
            "Sven Vath",
            "Art Department",
            "Guy Gerber",
            "Ilario Alicante",
            "Julian Jeweil",
            "Ernesto Ferreyra",
            "Luis Nieva",
            "Londonground",
    };

    String[] djTimes = {
            "00:15 - 02:15",
            "02:45 - 04:15",
            "04:45 - 06:00",
            "21:00 - 22:00",
            "22:15 - 23:45",
            "19:45 - 20:45",
            "18:45 - 19:30",
            "18:00 - 18:30",
            "16:00 - 18:00",
            "04:15 - 06:00",
            "02:15 - 04:00",
            "00:30 - 02:15",
            "22:30 - 00:30",
            "20:30 - 22:30",
            "19:00 - 20:30",
            "17:30 - 19:00",
            "16:00 - 17:30",
            "04:15 - 06:00",
            "02:15 - 04:15",
            "00:15 - 02:15",
            "22:45 - 00:15",
            "21:00 - 22:45",
            "20:00 - 21:00",
            "19:00 - 20:00",
            "18:00 - 19:00",
            "17:00 - 18:00",
            "16:00 - 17:00",
            "04:00 - 06:00",
            "03:00 - 04:00",
            "01:30 - 03:00",
            "00:00 - 01:30",
            "22:00 - 00:00",
            "20:30 - 22:00",
            "19:30 - 20:30",
            "18:30 - 19:30",
            "17:15 - 18:30",
            "16:00 - 17:15",
            "04:30 - 06:00",
            "02:30 - 04:30",
            "00:30 - 02:30",
            "23:00 - 00:30",
            "21:30 - 23:00",
            "20:00 - 21:30",
            "18:45 - 20:00",
            "17:15 - 18:45",
            "16:00 - 17:15",
    };
}