package sinhVien;

public class SinhVien {
    private int MaSV;
    private String TenSV;
    private String QueQuan;
    private Diem DiemSV;
    private Lop LopSV;

    public int getMaSV(){
        return MaSV;
    }

    public void setMaSV(int MaSV){
        this.MaSV = MaSV;
    }

    public String getTenSV(){
        return TenSV;
    }

    public void setTenSV(String TenSV){
        this.TenSV = TenSV;
    }

    public String getQueQuan(){
        return QueQuan;
    }

    public void setQueQuan(String QueQuan){
        this.QueQuan = QueQuan;
    }

    public Diem getDiemSV(){
        return DiemSV;
    }

    public void setDiemSV(Diem DiemSV){
        this.DiemSV = DiemSV;
    }

    public Lop getLopSV(){
        return LopSV;
    }

    public void setLopSV(Lop LopSV){
        this.LopSV = LopSV;
    }
}
