package com.github.jakesully123456.Generation;

public class GenUtil {
	
	public static String absolutePath;
	
    public static final double data_ax_v = 51.723685;
    public static final double data_ay_v = 0.426118;
    public static final double data_bx_v = 51.238917;
    public static final double data_by_v = -0.59728;
    ///
    public static final double data_xd_v = data_ax_v - data_bx_v;
    public static final double data_yd_v = data_ay_v - data_by_v;
    //
    public static final double data_x_unit = data_xd_v / 50000;
    public static final double data_y_unit = data_yd_v / 50000;

    public static double sixdp(double v) {
        return Math.round(v * 1000000) / 1000000;
    }

    public static double latTOgr(double v) {
        return sixdp((v - data_bx_v) / data_x_unit);
    }
    public static double longTOgr(double v) {
        return sixdp((v - data_by_v) / data_y_unit);
    }
    public static double grTOlat(double v) {
        return data_bx_v + ( sixdp(v) * data_x_unit);
    }
    public static double grTOlong(double v) {
        return data_by_v + ( sixdp(v) * data_y_unit);
    }

    
    public static void setAbsolutePath(String absolutePath) {
    	GenUtil.absolutePath = absolutePath;
    }
}
