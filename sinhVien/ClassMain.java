package sinhVien;

public class ClassMain {
    public static void main(String[] args) {
        PhuongThuc pt = new PhuongThuc();
        DanhSach ds = new DanhSach();
        pt.InputDSSV(ds);
        pt.OutputDSSV(ds);
    }
}
