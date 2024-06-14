
package Model;

import java.io.*;
import java.util.Objects;

public class HocSinh implements Serializable {
    protected String maHS;
    protected String hoTen;
    protected String lop;
    protected String danhHieu;
    protected String gioiTinh;

    public HocSinh() {
    }

    public HocSinh(String maHS) {
        this.maHS = maHS;
    }
    
    public HocSinh(String maHS, String hoTen, String lop, String danhHieu, String gioiTinh) {
        this.maHS = maHS;
        this.hoTen = hoTen;
        this.lop = lop;
        this.danhHieu = danhHieu;
        this.gioiTinh = gioiTinh;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public String getLop() {
        return lop;
    }
    
    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getDanhHieu() {
        return danhHieu;
    }

    public void setDanhHieu(String danhHieu) {
        this.danhHieu = danhHieu;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    @Override
    public String toString() {
        return maHS + "," + hoTen + "," + lop + "," + danhHieu + "," + gioiTinh;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HocSinh other = (HocSinh) obj;
        return Objects.equals(this.maHS, other.maHS);
    } 
}
